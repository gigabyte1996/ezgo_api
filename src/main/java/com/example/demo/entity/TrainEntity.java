package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Train")
public class TrainEntity {

    @Id
    @Column(name = "TrainID")
    private String trainID;

    @Basic
    @Column(name = "TrainNumber")
    private String trainNumber;

    @Basic
    @Column(name = "TrainType")
    private int trainType;


    @OneToMany(mappedBy = "trainEntity", cascade = CascadeType.ALL)
    private List<SteamerEntity> steamerEntities;

    @OneToMany(mappedBy = "trainEntity", cascade = CascadeType.ALL)
    private List<TrainScheduleEntity> trainScheduleEntities;

    public String getTrainID() {
        return trainID;
    }

    public void setTrainID(String trainID) {
        this.trainID = trainID;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public int getTrainType() {
        return trainType;
    }

    public void setTrainType(int trainType) {
        this.trainType = trainType;
    }

    public List<SteamerEntity> getSteamerEntities() {
        return steamerEntities;
    }

    public void setSteamerEntities(List<SteamerEntity> steamerEntities) {
        this.steamerEntities = steamerEntities;
    }

    public List<TrainScheduleEntity> getTrainScheduleEntities() {
        return trainScheduleEntities;
    }

    public void setTrainScheduleEntities(List<TrainScheduleEntity> trainScheduleEntities) {
        this.trainScheduleEntities = trainScheduleEntities;
    }
}
