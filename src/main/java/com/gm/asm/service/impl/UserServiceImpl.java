package com.gm.asm.service.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gm.asm.response.userid.UserResponse;
import com.gm.asm.service.UserService;
import org.json.JSONArray;
import org.json.JSONObject;
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
    public String getUserByUserName(String userName) {
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
            JSONObject jsonObject = new JSONObject(response.body().toString());
            JSONArray result = jsonObject.getJSONArray("value");
            String id = result.getJSONObject(0).get("id").toString();
            return id;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
