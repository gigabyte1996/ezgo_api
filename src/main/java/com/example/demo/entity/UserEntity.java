package com.example.demo.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @Column(name = "UserID")
    private String userID;

    @Basic
    @Column(name = "username")
    private String username;

    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "activated")
    private String activated;

    @Basic
    @Column(name = "statusID")
    private String statusID;

    @Basic
    @Column(name = "firstName")
    private String firstName;

    @Basic
    @Column(name = "lastName")
    private String lastName;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "avaImageURL")
    private String avaImageURL;

    @Basic
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Basic
    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    @Basic
    @Column(name = "gender")
    private int gender;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<TicketEntity> ticketEntities;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
