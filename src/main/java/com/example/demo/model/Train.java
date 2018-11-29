package com.example.demo.model;

public class Train {
    private Integer trainID;
    private String trainName;
    private Integer trainType;
    private boolean pantryCar;

    public Train(Integer trainID, String trainName, Integer trainType, boolean pantryCar) {
        this.trainID = trainID;
        this.trainName = trainName;
        this.trainType = trainType;
        this.pantryCar = pantryCar;
    }

    public Train() {
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
}
