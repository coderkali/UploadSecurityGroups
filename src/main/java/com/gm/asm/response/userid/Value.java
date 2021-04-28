package com.gm.asm.response.userid;

import java.util.List;
import java.util.Objects;

public class Value{
    public String id;
    public String descriptor;
    public String subjectDescriptor;
    public String providerDisplayName;
    public boolean isActive;
    public List<Object> members;
    public List<Object> memberOf;
    public List<Object> memberIds;
    public String masterId;
    public Properties properties;
    public int resourceVersion;
    public int metaTypeId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Value)) return false;
        Value value = (Value) o;
        return isActive() == value.isActive() && getResourceVersion() == value.getResourceVersion() && getMetaTypeId() == value.getMetaTypeId() && getId().equals(value.getId()) && getDescriptor().equals(value.getDescriptor()) && getSubjectDescriptor().equals(value.getSubjectDescriptor()) && getProviderDisplayName().equals(value.getProviderDisplayName()) && getMembers().equals(value.getMembers()) && getMemberOf().equals(value.getMemberOf()) && getMemberIds().equals(value.getMemberIds()) && getMasterId().equals(value.getMasterId()) && getProperties().equals(value.getProperties());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescriptor(), getSubjectDescriptor(), getProviderDisplayName(), isActive(), getMembers(), getMemberOf(), getMemberIds(), getMasterId(), getProperties(), getResourceVersion(), getMetaTypeId());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public String getSubjectDescriptor() {
        return subjectDescriptor;
    }

    public void setSubjectDescriptor(String subjectDescriptor) {
        this.subjectDescriptor = subjectDescriptor;
    }

    public String getProviderDisplayName() {
        return providerDisplayName;
    }

    public void setProviderDisplayName(String providerDisplayName) {
        this.providerDisplayName = providerDisplayName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<Object> getMembers() {
        return members;
    }

    public void setMembers(List<Object> members) {
        this.members = members;
    }

    public List<Object> getMemberOf() {
        return memberOf;
    }

    public void setMemberOf(List<Object> memberOf) {
        this.memberOf = memberOf;
    }

    public List<Object> getMemberIds() {
        return memberIds;
    }

    public void setMemberIds(List<Object> memberIds) {
        this.memberIds = memberIds;
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public int getResourceVersion() {
        return resourceVersion;
    }

    public void setResourceVersion(int resourceVersion) {
        this.resourceVersion = resourceVersion;
    }

    public int getMetaTypeId() {
        return metaTypeId;
    }

    public void setMetaTypeId(int metaTypeId) {
        this.metaTypeId = metaTypeId;
    }
}