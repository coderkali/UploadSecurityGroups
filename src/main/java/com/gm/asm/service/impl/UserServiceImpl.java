package com.gm.asm.service.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gm.asm.response.userid.UserResponse;
import com.gm.asm.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class UserServiceImpl  implements UserService {

    @Value("${app.aget.user.request.uri}")
    private String getUserUri;



    @Override
    public UserResponse getUserByUserName(String userName) {
        try{
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(getUserUri+userName))
                    .header("Connection", "keep-alive")
                    .header("Accept", "application/json, text/javascript, */*; q=0.01")
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Basic bmFtXGh6Mmd6OTpBYWJhbkA3ODY3ODY3ODY=")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            UserResponse userResponse = objectMapper.convertValue(response.body(),UserResponse.class);
            return userResponse;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
