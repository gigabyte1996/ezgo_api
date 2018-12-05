package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Train")
public class TrainEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TrainID")
    private Integer trainID;

    @Basic
    @Column(name = "TrainName")
    private String trainName;

    @Basic
    @Column(name = "TrainType")
    private Integer trainType;

    @Basic
    @Column(name = "PantryCar")
    private boolean pantryCar;


    @OneToMany(mappedBy = "trainEntity", cascade = CascadeType.ALL)
    private List<SteamerEntity> steamerEntities;

    @OneToMany(mappedBy = "trainEntity", cascade = CascadeType.ALL)
    private List<TrainScheduleEntity> trainScheduleEntities;

    public TrainEntity() {
    }

    public TrainEntity(String trainName, Integer trainType, boolean pantryCar, List<SteamerEntity> steamerEntities, List<TrainScheduleEntity> trainScheduleEntities) {
        this.trainName = trainName;
        this.trainType = trainType;
        this.pantryCar = pantryCar;
        this.steamerEntities = steamerEntities;
        this.trainScheduleEntities = trainScheduleEntities;
    }

    public Integer getTrainID() {
        return trainID;
    }

    public void setTrainID(Integer trainID) {
        this.trainID = trainID;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public Integer getTrainType() {
        return trainType;
    }

    public void setTrainType(Integer trainType) {
        this.trainType = trainType;
    }

    public boolean isPantryCar() {
        return pantryCar;
    }

    public void setPantryCar(boolean pantryCar) {
        this.pantryCar = pantryCar;
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
