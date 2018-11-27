package com.example.demo.model;

public class Train {
    private Integer trainID;
    private String trainName;
    private int trainType;
    private boolean pantryCar;

    public Train(Integer trainID, String trainName, int trainType, boolean pantryCar) {
        this.trainID = trainID;
        this.trainName = trainName;
        this.trainType = trainType;
        this.pantryCar = pantryCar;

    }

    public Train() {
        super();
    }

    public Integer getTrainID() {

        return trainID;
    }

    public void setTrainID(Integer trainID) {
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
