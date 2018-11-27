package com.example.demo.model;

import java.util.Date;

public class Ticket {
    private String ticketID;
    private String userID;
    private String fareScheduleID;
    private String FromStation;
    private String toStation;
    private String scheduleTypeCode;
    private String trainCode;
    private String seatCode;
    private String steamerCode;
    private String singleOrReturn;
    private Long fare;
    private String passengerName;
    private String identificationNumber;
    private Date dateOfBirth;
    private int age;
    private String ticketCode;

    public Ticket() {

    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getFareScheduleID() {
        return fareScheduleID;
    }

    public void setFareScheduleID(String fareScheduleID) {
        this.fareScheduleID = fareScheduleID;
    }

    public String getFromStation() {
        return FromStation;
    }

    public void setFromStation(String fromStation) {
        FromStation = fromStation;
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

    public String getSingleOrReturn() {
        return singleOrReturn;
    }

    public void setSingleOrReturn(String singleOrReturn) {
        this.singleOrReturn = singleOrReturn;
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

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Ticket(String ticketID, String userID, String fareScheduleID, String fromStation, String toStation, String scheduleTypeCode, String trainCode, String seatCode, String steamerCode, String singleOrReturn, Long fare, String passengerName, String identificationNumber, Date dateOfBirth, int age, String ticketCode) {
        this.ticketID = ticketID;
        this.userID = userID;
        this.fareScheduleID = fareScheduleID;
        FromStation = fromStation;
        this.toStation = toStation;
        this.scheduleTypeCode = scheduleTypeCode;
        this.trainCode = trainCode;
        this.seatCode = seatCode;
        this.steamerCode = steamerCode;
        this.singleOrReturn = singleOrReturn;
        this.fare = fare;
        this.passengerName = passengerName;
        this.identificationNumber = identificationNumber;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.ticketCode = ticketCode;
    }
}
