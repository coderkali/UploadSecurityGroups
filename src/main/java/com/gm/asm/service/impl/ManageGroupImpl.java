package com.gm.asm.service.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gm.asm.request.ManageGroupRequest;
import com.gm.asm.response.ManageGroupResponse;
import com.gm.asm.response.userid.UserResponse;
import com.gm.asm.service.ManageGroupI;
import com.gm.asm.service.UserService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Value("${app.auth.token}")
    private String appAuthToken;

    @Autowired
    UserService userService;


    @Override
    public String manageGroup(ManageGroupRequest manageGroupRequest) {
        try {
            String id="";
            JSONObject obj=new JSONObject();
            obj.put("name",manageGroupRequest.getName());
            String names = obj.toString();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(manageGroupUri))
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Basic "+appAuthToken)
                .method("POST", HttpRequest.BodyPublishers.ofString(names))
                .build();
            HttpResponse<String> response = null;
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode()==500){
                return userService.getUserByUserName(manageGroupRequest.getName());
            }
            JSONObject jsonObject = new JSONObject(response.body().toString());
            String ids =jsonObject.get("teamFoundationId").toString();
            return ids;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
