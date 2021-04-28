package com.gm.asm.response.userid;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class SpecialType{
    @JsonProperty("$type")
    public String type;
    @JsonProperty("$value") 
    public String value;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpecialType)) return false;
        SpecialType that = (SpecialType) o;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}