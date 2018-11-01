package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class TicketEntity {
    @Id
    @Column(name = "TicketID")
    private String id;

    @Basic
    @Column(name = "fromStation")
    private String fromStation;

    @Basic
    @Column(name = "toStation")
    private String toStation;

    @Basic
    @Column(name = "scheduleTypeCode")
    private String scheduleTypeCode;

    @Basic
    @Column(name = "trainCode")
    private String trainCode;

    @Basic
    @Column(name = "seatCode")
    private String seatCode;

    @Basic
    @Column(name = "steamerCode")
    private String steamerCode;

    @Basic
    @Column(name = "singleOrReturn")
    private String singOrReTurn;

    @Basic
    @Column(name = "fare")
    private Long fare;

    @Basic
    @Column(name = "PassengerName")
    private  String passengerName;

    @Basic
    @Column(name = "Email")
    private String email;

    @Basic
    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Basic
    @Column(name = "IdentificationNumber")
    private String identificationNumber;

    @Basic
    @Column(name = "Age")
    private int age;

    @Basic
    @Column(name = "TicketCode")
    private String ticketCode;

    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    public UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "seatID", nullable = false)
    public SeatEntity seatEntity;

    @ManyToOne
    @JoinColumn(name = "FareScheduleID", nullable = false)
    private FareScheduleEntity fareScheduleEntity;

    public FareScheduleEntity getFareScheduleEntity() {
        return fareScheduleEntity;
    }

    public void setFareScheduleEntity(FareScheduleEntity fareScheduleEntity) {
        this.fareScheduleEntity = fareScheduleEntity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public String getScheduleTypeCode() {
        return scheduleTypeCode;
    }

    public void setScheduleTypeCode(String scheduleTypeCode) {
        this.scheduleTypeCode = scheduleTypeCode;
    }

    public String getTrainCode() {
        return trainCode;
    }

    public void setTrainCode(String trainCode) {
        this.trainCode = trainCode;
    }

    public String getSeatCode() {
        return seatCode;
    }

    public void setSeatCode(String seatCode) {
        this.seatCode = seatCode;
    }

    public String getSteamerCode() {
        return steamerCode;
    }

    public void setSteamerCode(String steamerCode) {
        this.steamerCode = steamerCode;
    }

    public String getSingOrReTurn() {
        return singOrReTurn;
    }

    public void setSingOrReTurn(String singOrReTurn) {
        this.singOrReTurn = singOrReTurn;
    }

    public Long getFare() {
        return fare;
    }

    public void setFare(Long fare) {
        this.fare = fare;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }
}
