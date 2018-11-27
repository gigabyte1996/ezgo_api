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
    private int trainType;

    @Basic
    @Column(name = "PantryCar")
    private boolean pantryCar;


    @OneToMany(mappedBy = "trainEntity", cascade = CascadeType.ALL)
    private List<SteamerEntity> steamerEntities;

    @OneToMany(mappedBy = "trainEntity", cascade = CascadeType.ALL)
    private List<TrainScheduleEntity> trainScheduleEntities;

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

    public boolean isPantryCar() {
        return pantryCar;
    }

    public void setPantryCar(boolean pantryCar) {
        this.pantryCar = pantryCar;
    }
}
