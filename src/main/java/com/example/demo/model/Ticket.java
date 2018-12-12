package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Date;

public class Ticket {
    private Integer ticketID;
    private Integer userID;
    private Integer trainScheduleID;
    private String fromStation;
    private String toStation;
    private String trainScheduleCode;
    private Integer ticketStatus;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Ho_Chi_Minh")
    private Date departureTime;
    private String trainScheduleName;
    private String trainName;
    private Integer carrageNumber;
    private Integer seatNumber;
    private Integer carrageType;
    private Integer seatLocation;
    private Integer fare;
    private String ticketCode;
//    private LocalDateTime createDate;
    private String passengerName;
    private String ticketType;
    private String identificationNumber;
    private Date dateOfBirth;

    public Ticket() {

    }


    public String getTrainScheduleCode() {
        return trainScheduleCode;
    }

    public void setTrainScheduleCode(String trainScheduleCode) {
        this.trainScheduleCode = trainScheduleCode;
    }

    public Integer getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(Integer ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Integer getTicketID() {
        return ticketID;
    }

    public void setTicketID(Integer ticketID) {
        this.ticketID = ticketID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getTrainScheduleID() {
        return trainScheduleID;
    }

    public void setTrainScheduleID(Integer trainScheduleID) {
        this.trainScheduleID = trainScheduleID;
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

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getTrainScheduleName() {
        return trainScheduleName;
    }

    public void setTrainScheduleName(String trainScheduleName) {
        this.trainScheduleName = trainScheduleName;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public Integer getCarrageNumber() {
        return carrageNumber;
    }

    public void setCarrageNumber(Integer carrageNumber) {
        this.carrageNumber = carrageNumber;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Integer getCarrageType() {
        return carrageType;
    }

    public void setCarrageType(Integer carrageType) {
        this.carrageType = carrageType;
    }

    public Integer getSeatLocation() {
        return seatLocation;
    }

    public void setSeatLocation(Integer seatLocation) {
        this.seatLocation = seatLocation;
    }

    public Integer getFare() {
        return fare;
    }

    public void setFare(Integer fare) {
        this.fare = fare;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

//    public LocalDateTime getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(LocalDateTime createDate) {
//        this.createDate = createDate;
//    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public Ticket(Integer ticketID, Integer userID, Integer trainScheduleID, String fromStation, String toStation, String trainScheduleCode, Integer ticketStatus, Date departureTime, String trainScheduleName, String trainName, Integer carrageNumber, Integer seatNumber, Integer carrageType, Integer seatLocation, Integer fare, String ticketCode, String passengerName, String ticketType, String identificationNumber, Date dateOfBirth) {
        this.ticketID = ticketID;
        this.userID = userID;
        this.trainScheduleID = trainScheduleID;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.trainScheduleCode = trainScheduleCode;
        this.ticketStatus = ticketStatus;
        this.departureTime = departureTime;
        this.trainScheduleName = trainScheduleName;
        this.trainName = trainName;
        this.carrageNumber = carrageNumber;
        this.seatNumber = seatNumber;
        this.carrageType = carrageType;
        this.seatLocation = seatLocation;
        this.fare = fare;
        this.ticketCode = ticketCode;
        this.passengerName = passengerName;
        this.ticketType = ticketType;
        this.identificationNumber = identificationNumber;
        this.dateOfBirth = dateOfBirth;
    }
}
