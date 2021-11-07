package com.practise.spring.practise.PersonDetails.model;

public class Parameters {
    String type;

    public Parameters() {
    }

    public Parameters(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Parameters{" +
                "type='" + type + '\'' +
                '}';
    }
}
