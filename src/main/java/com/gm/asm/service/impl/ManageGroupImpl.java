package com.gm.asm.service.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gm.asm.request.ManageGroupRequest;
import com.gm.asm.response.ManageGroupResponse;
import com.gm.asm.response.userid.UserResponse;
import com.gm.asm.service.ManageGroupI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ManageGroupImpl implements ManageGroupI {

    @Value("${app.manage.group.request.uri}")
    private String manageGroupUri;


    @Override
    public ManageGroupResponse manageGroup(ManageGroupRequest manageGroupRequest) {
        try {
           HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(manageGroupUri))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Basic bmFtXGh6Mmd6OTpBYWJhbkA3ODY3ODY3ODY=")
                .method("POST", HttpRequest.BodyPublishers.ofString(manageGroupRequest.toString()))
                .build();
            HttpResponse<String> response = null;
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            ManageGroupResponse manageGroupResponse = objectMapper.convertValue(response.body(),ManageGroupResponse.class);
            return manageGroupResponse;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
