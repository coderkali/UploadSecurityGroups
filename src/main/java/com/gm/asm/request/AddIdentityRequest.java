package com.gm.asm.request;

import java.util.Objects;

public class AddIdentityRequest {

    private String newUsersJson;
    private String existingUsersJson;
    private String groupsToJoinJson;
    private String aadGroupsJson;


    public String getNewUsersJson() {
        return newUsersJson;
    }

    public void setNewUsersJson(String newUsersJson) {
        this.newUsersJson = newUsersJson;
    }

    public String getExistingUsersJson() {
        return existingUsersJson;
    }

    public void setExistingUsersJson(String existingUsersJson) {
        this.existingUsersJson = existingUsersJson;
    }

    public String getGroupsToJoinJson() {
        return groupsToJoinJson;
    }

    public void setGroupsToJoinJson(String groupsToJoinJson) {
        this.groupsToJoinJson = groupsToJoinJson;
    }

    public String getAadGroupsJson() {
        return aadGroupsJson;
    }

    public void setAadGroupsJson(String aadGroupsJson) {
        this.aadGroupsJson = aadGroupsJson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddIdentityRequest)) return false;
        AddIdentityRequest that = (AddIdentityRequest) o;
        return getNewUsersJson().equals(that.getNewUsersJson()) && getExistingUsersJson().equals(that.getExistingUsersJson()) && getGroupsToJoinJson().equals(that.getGroupsToJoinJson()) && getAadGroupsJson().equals(that.getAadGroupsJson());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNewUsersJson(), getExistingUsersJson(), getGroupsToJoinJson(), getAadGroupsJson());
    }
}
