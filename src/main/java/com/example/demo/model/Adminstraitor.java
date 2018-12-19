package com.example.demo.model;

public class Adminstraitor {
    private String adminstraitorName;
    private String adminPhoneNum;

    public String getAdminstraitorName() {
        return adminstraitorName;
    }

    public void setAdminstraitorName(String adminstraitorName) {
        this.adminstraitorName = adminstraitorName;
    }

    public String getAdminPhoneNum() {
        return adminPhoneNum;
    }

    public void setAdminPhoneNum(String adminPhoneNum) {
        this.adminPhoneNum = adminPhoneNum;
    }

    public Adminstraitor(String adminstraitorName, String adminPhoneNum) {
        this.adminstraitorName = adminstraitorName;
        this.adminPhoneNum = adminPhoneNum;
    }

    public Adminstraitor() {
    }
}
