package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "steamer")
public class SteamerEntity {

    @Id
    @Column(name = "SteamerID")
    private String steamerID;

    @Basic
    @Column(name = "SteamerNumber")
    private int steamerNumber;

    @Basic
    @Column(name = "SteamerType")
    private int steamerType;

    @Basic
    @Column(name = "AirCondition")
    private boolean airCondition;

    @OneToMany(mappedBy = "steamerEntity", cascade = CascadeType.ALL)
    private List<SeatEntity> seatEntities;

    @ManyToOne
    @JoinColumn(name = "trainID", nullable = true)
    private TrainEntity trainEntity;


    public String getSteamerID() {
        return steamerID;
    }

    public void setSteamerID(String steamerID) {
        this.steamerID = steamerID;
    }

    public int getSteamerNumber() {
        return steamerNumber;
    }

    public void setSteamerNumber(int steamerNumber) {
        this.steamerNumber = steamerNumber;
    }

    public int getSteamerType() {
        return steamerType;
    }

    public void setSteamerType(int steamerType) {
        this.steamerType = steamerType;
    }

    public boolean isAirCondition() {
        return airCondition;
    }

    public void setAirCondition(boolean airCondition) {
        this.airCondition = airCondition;
    }

    public List<SeatEntity> getSeatEntities() {
        return seatEntities;
    }

    public void setSeatEntities(List<SeatEntity> seatEntities) {
        this.seatEntities = seatEntities;
    }

    public TrainEntity getTrainEntity() {
        return trainEntity;
    }

    public void setTrainEntity(TrainEntity trainEntity) {
        this.trainEntity = trainEntity;
    }
}
