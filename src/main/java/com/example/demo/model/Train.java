package com.example.demo.model;

public class Train {
    private String trainID;
    private String trainName;
    private int trainType;
    private boolean pantryCar;

    public Train(String trainID, String trainName, int trainType, boolean pantryCar) {
        this.trainID = trainID;
        this.trainName = trainName;
        this.trainType = trainType;
        this.pantryCar = pantryCar;

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

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public boolean isPantryCar() {
        return pantryCar;
    }

    public void setPantryCar(boolean pantryCar) {
        this.pantryCar = pantryCar;
    }
}
