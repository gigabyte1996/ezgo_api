package com.example.demo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "seatStorage")
public class SeatStorageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seatStorageID")
    private Integer seatStorageID;

    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    public UserEntity userEntity;

    @Basic
    @Column(name = "trainName")
    private String trainName;

    @Basic
    @Column(name = "trainscheduleID")
    private Integer trainScheduleID;

    @Basic
    @Column(name = "seatID")
    private Integer seatID;

    @Basic
    @Column(name = "scheduleName")
    private String scheduleName;

    @Basic
    @Column(name = "departureTime")
    private Date departureTime;

    @Basic
    @Column(name = "carrageNumber")
    private Integer carrageNumber;

    @Basic
    @Column(name = "seatNumber")
    private Integer seatNumber;

    @Basic
    @Column(name = "carrageType")
    private Integer carrageType;

    @Basic
    @Column(name = "seatLocation")
    private Integer seatLocation;

    @Basic
    @Column(name = "fare")
    private Integer fare;

    @Basic
    @Column(name = "fromStation")
    private String fromStation;

    @Basic
    @Column(name = "toStation")
    private String toStation;


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

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
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

    public void setSeatID(Integer seatID) {
        this.seatID = seatID;
    }



    public SeatStorageEntity() {
    }


}
