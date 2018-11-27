package com.example.demo.service.response;

public class MessageResponse {
    private Integer code;
    private String description;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MessageResponse(Integer code, String description) {

        this.code = code;
        this.description = description;
    }
}
