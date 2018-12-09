package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

public class SeatStorage {


    private Integer userID;
    private Integer seatStorageID;
    private Integer trainScheduleID;
    private Integer seatID;
    private String trainName;
    private String scheduleName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone="Asia/Ho_Chi_Minh")
    private Date departureTime;

    private Integer carrageNumber;
    private Integer seatNumber;
    private Integer carrageType;
    private Integer seatLocation;
    private Integer fare;

    public Integer getCarrageType() {
        return carrageType;
    }

    public void setCarrageType(Integer carrageType) {
        this.carrageType = carrageType;
    }

    public Integer getSeatStorageID() {
        return seatStorageID;
    }

    public void setSeatStorageID(Integer seatStorageID) {
        this.seatStorageID = seatStorageID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
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

    public Integer getTrainScheduleID() {
        return trainScheduleID;
    }

    public void setTrainScheduleID(Integer trainScheduleID) {
        this.trainScheduleID = trainScheduleID;
    }

    public Integer getSeatID() {
        return seatID;
    }

    public void setSeatID(Integer seatID) {
        this.seatID = seatID;
    }

    public SeatStorage() {
    }

    public SeatStorage(Integer userID, Integer seatStorageID, Integer trainScheduleID, Integer seatID, String trainName, String scheduleName, Date departureTime, Integer carrageNumber, Integer seatNumber, Integer carrageType, Integer seatLocation, Integer fare) {
        this.userID = userID;
        this.seatStorageID = seatStorageID;
        this.trainScheduleID = trainScheduleID;
        this.seatID = seatID;
        this.trainName = trainName;
        this.scheduleName = scheduleName;
        this.departureTime = departureTime;
        this.carrageNumber = carrageNumber;
        this.seatNumber = seatNumber;
        this.carrageType = carrageType;
        this.seatLocation = seatLocation;
        this.fare = fare;
    }
}
