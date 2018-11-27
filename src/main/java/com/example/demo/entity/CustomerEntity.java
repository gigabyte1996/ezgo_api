package com.example.demo.entity;


import javax.persistence.*;

@Entity
@Table(name = "CustomerEntity")
public class CustomerEntity {
    @Id
    @Column(name = "CustomerID")
    private int CustomerID;

    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    public UserEntity userEntity;

    @Basic
    @Column(name = "customerName")
    private  String customerName;

    @Basic
    @Column(name = "Email")
    private String email;

    @Basic
    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Basic
    @Column(name = "IdentificationNumber")
    private String identificationNumber;

    public CustomerEntity(int customerID, UserEntity userEntity, String customerName, String email, String phoneNumber, String identificationNumber) {
        CustomerID = customerID;
        this.userEntity = userEntity;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.identificationNumber = identificationNumber;
    }

    public CustomerEntity() {
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
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
