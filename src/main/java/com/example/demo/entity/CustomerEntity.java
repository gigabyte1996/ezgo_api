package com.example.demo.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CustomerEntity")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerID")
    private Integer customerID;

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

    @OneToMany(mappedBy = "customerEntity", cascade = CascadeType.ALL)
    private List<TicketEntity> ticketEntities;

    public CustomerEntity() {
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
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

    public List<TicketEntity> getTicketEntities() {
        return ticketEntities;
    }

    public void setTicketEntities(List<TicketEntity> ticketEntities) {
        this.ticketEntities = ticketEntities;
    }

    public CustomerEntity(UserEntity userEntity, String customerName, String email, String phoneNumber, String identificationNumber, List<TicketEntity> ticketEntities) {
        this.userEntity = userEntity;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.identificationNumber = identificationNumber;
        this.ticketEntities = ticketEntities;
    }
}
