package com.gm.asm.service.impl;

import com.gm.asm.request.AddIdentityRequest;
import com.gm.asm.service.AddIdentitiesI;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AddIdentityImpl implements AddIdentitiesI {

    @Value("${app.add.identity.request.uri}")
    private String addIdenityUri;


    @Override
    public void addIdentity(AddIdentityRequest identityRequest) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(addIdenityUri))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Basic bmFtXGh6Mmd6OTpBYWJhbkA3ODY3ODY3ODY=")
                    .method("POST", HttpRequest.BodyPublishers.ofString(identityRequest.toString()))
                    .build();
            HttpResponse<String> response = null;
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
