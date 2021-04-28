package com.gm.asm.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class ManageGroupResponse {

        @JsonProperty("IdentityType")
        public String identityType;
        @JsonProperty("FriendlyDisplayName")
        public String friendlyDisplayName;
        @JsonProperty("DisplayName")
        public String displayName;
        @JsonProperty("SubHeader")
        public String subHeader;
        @JsonProperty("TeamFoundationId")
        public String teamFoundationId;
        @JsonProperty("EntityId")
        public String entityId;
        @JsonProperty("Errors")
        public List<Object> errors;
        @JsonProperty("Warnings")
        public List<Object> warnings;
        @JsonProperty("IsWindowsGroup")
        public boolean isWindowsGroup;
        @JsonProperty("IsAadGroup")
        public boolean isAadGroup;
        @JsonProperty("Description")
        public String description;
        @JsonProperty("Scope")
        public String scope;
        @JsonProperty("MemberCountText")
        public String memberCountText;
        @JsonProperty("IsTeam")
        public boolean isTeam;
        @JsonProperty("IsProjectLevel")
        public boolean isProjectLevel;

    public ManageGroupResponse(String identityType, String friendlyDisplayName, String displayName, String subHeader, String teamFoundationId, String entityId, List<Object> errors, List<Object> warnings, boolean isWindowsGroup, boolean isAadGroup, String description, String scope, String memberCountText, boolean isTeam, boolean isProjectLevel) {
        this.identityType = identityType;
        this.friendlyDisplayName = friendlyDisplayName;
        this.displayName = displayName;
        this.subHeader = subHeader;
        this.teamFoundationId = teamFoundationId;
        this.entityId = entityId;
        this.errors = errors;
        this.warnings = warnings;
        this.isWindowsGroup = isWindowsGroup;
        this.isAadGroup = isAadGroup;
        this.description = description;
        this.scope = scope;
        this.memberCountText = memberCountText;
        this.isTeam = isTeam;
        this.isProjectLevel = isProjectLevel;
    }

    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    public String getFriendlyDisplayName() {
        return friendlyDisplayName;
    }

    public void setFriendlyDisplayName(String friendlyDisplayName) {
        this.friendlyDisplayName = friendlyDisplayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getSubHeader() {
        return subHeader;
    }

    public void setSubHeader(String subHeader) {
        this.subHeader = subHeader;
    }

    public String getTeamFoundationId() {
        return teamFoundationId;
    }

    public void setTeamFoundationId(String teamFoundationId) {
        this.teamFoundationId = teamFoundationId;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public List<Object> getErrors() {
        return errors;
    }

    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }

    public List<Object> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<Object> warnings) {
        this.warnings = warnings;
    }

    public boolean isWindowsGroup() {
        return isWindowsGroup;
    }

    public void setWindowsGroup(boolean windowsGroup) {
        isWindowsGroup = windowsGroup;
    }

    public boolean isAadGroup() {
        return isAadGroup;
    }

    public void setAadGroup(boolean aadGroup) {
        isAadGroup = aadGroup;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getMemberCountText() {
        return memberCountText;
    }

    public void setMemberCountText(String memberCountText) {
        this.memberCountText = memberCountText;
    }

    public boolean isTeam() {
        return isTeam;
    }

    public void setTeam(boolean team) {
        isTeam = team;
    }

    public boolean isProjectLevel() {
        return isProjectLevel;
    }

    public void setProjectLevel(boolean projectLevel) {
        isProjectLevel = projectLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ManageGroupResponse)) return false;
        ManageGroupResponse that = (ManageGroupResponse) o;
        return isWindowsGroup() == that.isWindowsGroup() && isAadGroup() == that.isAadGroup() && isTeam() == that.isTeam() && isProjectLevel() == that.isProjectLevel() && getIdentityType().equals(that.getIdentityType()) && getFriendlyDisplayName().equals(that.getFriendlyDisplayName()) && getDisplayName().equals(that.getDisplayName()) && getSubHeader().equals(that.getSubHeader()) && getTeamFoundationId().equals(that.getTeamFoundationId()) && getEntityId().equals(that.getEntityId()) && getErrors().equals(that.getErrors()) && getWarnings().equals(that.getWarnings()) && getDescription().equals(that.getDescription()) && getScope().equals(that.getScope()) && getMemberCountText().equals(that.getMemberCountText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdentityType(), getFriendlyDisplayName(), getDisplayName(), getSubHeader(), getTeamFoundationId(), getEntityId(), getErrors(), getWarnings(), isWindowsGroup(), isAadGroup(), getDescription(), getScope(), getMemberCountText(), isTeam(), isProjectLevel());
    }
}
