package com.gm.asm.service.impl;

import com.gm.asm.request.AddIdentityRequest;
import com.gm.asm.service.AddIdentitiesI;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class AddIdentityImpl implements AddIdentitiesI {

    @Value("${app.add.identity.request.uri}")
    private String addIdenityUri;

    @Value("${app.auth.token}")
    private String appAuthToken;


    @Override
    public void addIdentity(AddIdentityRequest identityRequest) {
        try {
            JSONObject obj=new JSONObject();
            obj.put("newUsersJson","");
            obj.put("existingUsersJson",identityRequest.getExistingUsersJson());
            obj.put("groupsToJoinJson",identityRequest.getGroupsToJoinJson());
            obj.put("aadGroupsJson","");
            String identity= obj.toString();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(addIdenityUri))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Basic "+appAuthToken)
                    .method("POST", HttpRequest.BodyPublishers.ofString(identity))
                    .build();
            HttpResponse<String> response = null;
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
