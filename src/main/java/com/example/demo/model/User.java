package com.example.demo.model;

import java.util.Date;

public class User {
    private String UserID;
    private String username;
    private String password;
    private  String mail;
    private String fullname;
    private Boolean gender;
    private String activated;
    private String statusID;
    private String email;
    private String avaImageURL;
    private String phoneNumber;
    private Date dateOfBirth;

    public User() {
    }

    public User(String userID, String username, String password, String mail, String fullname, Boolean gender, String activated, String statusID, String firstName, String lastName, String email, String avaImageURL, String phoneNumber, Date dateOfBirth) {
        UserID = userID;
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.fullname = fullname;
        this.gender = gender;
        this.activated = activated;
        this.statusID = statusID;
        this.email = email;
        this.avaImageURL = avaImageURL;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswprd() {
        return password;
    }

    public void setPasswprd(String passwprd) {
        this.password = passwprd;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getActivated() {
        return activated;
    }

    public void setActivated(String activated) {
        this.activated = activated;
    }

    public String getStatusID() {
        return statusID;
    }

    public void setStatusID(String statusID) {
        this.statusID = statusID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvaImageURL() {
        return avaImageURL;
    }

    public void setAvaImageURL(String avaImageURL) {
        this.avaImageURL = avaImageURL;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
