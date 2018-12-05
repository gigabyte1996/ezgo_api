package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "steamer")
public class SteamerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SteamerID")
    private Integer steamerID;

    @Basic
    @Column(name = "SteamerNumber")
    private Integer steamerNumber;

    @Basic
    @Column(name = "SteamerType")
    private Integer steamerType;

    @Basic
    @Column(name = "AirCondition")
    private boolean airCondition;

    @OneToMany(mappedBy = "steamerEntity", cascade = CascadeType.ALL)
    private List<SeatEntity> seatEntities;

    @ManyToOne
    @JoinColumn(name = "trainID", nullable = true)
    private TrainEntity trainEntity;


    public Integer getSteamerID() {
        return steamerID;
    }

    public void setSteamerID(Integer steamerID) {
        this.steamerID = steamerID;
    }

    public Integer getSteamerNumber() {
        return steamerNumber;
    }

    public void setSteamerNumber(Integer steamerNumber) {
        this.steamerNumber = steamerNumber;
    }

    public Integer getSteamerType() {
        return steamerType;
    }

    public void setSteamerType(Integer steamerType) {
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
