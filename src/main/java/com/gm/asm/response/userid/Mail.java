package com.gm.asm.response.userid;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Mail{
    @JsonProperty("$type")
    public String type;
    @JsonProperty("$value") 
    public String value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mail)) return false;
        Mail mail = (Mail) o;
        return getType().equals(mail.getType()) && getValue().equals(mail.getValue());
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