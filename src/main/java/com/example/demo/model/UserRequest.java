package com.example.demo.model;

public class UserRequest {
    private Integer userID;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public UserRequest(Integer userID) {
        this.userID = userID;
    }
}
