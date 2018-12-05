package com.example.demo.model;

import java.util.List;

public class TrainDetail {
    private Integer trainID;
    private String trainName;
    private Integer trainType;
    private boolean pantryCar;
    private List<Steamer> steamerList;

    public TrainDetail() {
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

    public List<Steamer> getSteamerList() {
        return steamerList;
    }

    public void setSteamerList(List<Steamer> steamerList) {
        this.steamerList = steamerList;
    }

    public TrainDetail(Integer trainID, String trainName, Integer trainType, boolean pantryCar, List<Steamer> steamerList) {
        this.trainID = trainID;
        this.trainName = trainName;
        this.trainType = trainType;
        this.pantryCar = pantryCar;
        this.steamerList = steamerList;
    }
}
