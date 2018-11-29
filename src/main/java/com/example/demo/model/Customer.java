package com.example.demo.model;

public class Customer {
    private Integer customerID;
    private Integer userID;
    private String customerName;
    private String email;
    private String phoneNumber;
    private String identificationNumber;

    public Customer() {
    }

    public Customer(Integer customerID, Integer userID, String customerName, String email, String phoneNumber, String identificationNumber) {
        this.customerID = customerID;
        this.userID = userID;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.identificationNumber = identificationNumber;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }
}
