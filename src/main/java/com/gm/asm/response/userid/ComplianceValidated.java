package com.gm.asm.response.userid;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Objects;

public class ComplianceValidated{
    @JsonProperty("$type")
    public String type;
    @JsonProperty("$value") 
    public Date value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComplianceValidated)) return false;
        ComplianceValidated that = (ComplianceValidated) o;
        return getType().equals(that.getType()) && getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getValue());
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getValue() {
        return value;
    }

    public void setValue(Date value) {
        this.value = value;
    }
}