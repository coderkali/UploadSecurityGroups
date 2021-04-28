package com.gm.asm.response.userid;

import java.util.List;
import java.util.Objects;

public class UserResponse {

    public int count;
    public List<Value> value;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Value> getValue() {
        return value;
    }

    public void setValue(List<Value> value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserResponse)) return false;
        UserResponse user = (UserResponse) o;
        return getCount() == user.getCount() && getValue().equals(user.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCount(), getValue());
    }
}
