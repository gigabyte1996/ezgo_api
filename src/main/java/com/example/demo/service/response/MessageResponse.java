package com.example.demo.service.response;

public class MessageResponse {
    private int code;
    private String description;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MessageResponse(int code, String description) {

        this.code = code;
        this.description = description;
    }
}
