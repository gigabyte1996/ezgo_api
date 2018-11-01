package com.example.demo.model;

public class Train {
    private String trainID;
    private String trainName;
    private int trainType;

    public Train(String trainID, String trainName, int trainType) {
        this.trainID = trainID;
        this.trainName = trainName;
        this.trainType = trainType;
    }

    public Train() {
        super();
    }

    public String getTrainID() {

        return trainID;
    }

    public void setTrainID(String trainID) {
        this.trainID = trainID;
    }

    public String getTrainNumber() {
        return trainName;
    }

    public void setTrainNumber(String trainName) {
        this.trainName = trainName;
    }

    public int getTrainType() {
        return trainType;
    }

    public void setTrainType(int trainType) {
        this.trainType = trainType;
    }
}
