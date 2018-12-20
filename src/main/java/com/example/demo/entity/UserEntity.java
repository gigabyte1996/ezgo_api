package com.example.demo.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Integer userID;

    @Basic
    @Column(name = "username")
    private String username;

    @Basic
    @Column(name = "password")
    private String password;


    @Basic
    @Column(name = "role")
    private String role;

    @Basic
    @Column(name = "fullName")
    private String fullName;


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
    private Boolean gender;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<TicketEntity> ticketEntities;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<SeatStorageEntity> ticketPocketEntities;

//    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
//    private List<CustomerEntity> customerEntities;


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
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


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public List<TicketEntity> getTicketEntities() {
        return ticketEntities;
    }

    public void setTicketEntities(List<TicketEntity> ticketEntities) {
        this.ticketEntities = ticketEntities;
    }

    public List<SeatStorageEntity> getTicketPocketEntities() {
        return ticketPocketEntities;
    }

    public void setTicketPocketEntities(List<SeatStorageEntity> ticketPocketEntities) {
        this.ticketPocketEntities = ticketPocketEntities;
    }
    //
//    public List<CustomerEntity> getCustomerEntities() {
//        return customerEntities;
//    }
//
//    public void setCustomerEntities(List<CustomerEntity> customerEntities) {
//        this.customerEntities = customerEntities;
//    }
}
