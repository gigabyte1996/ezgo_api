package com.example.demo.service.response;

import com.example.demo.model.Steamer;

import java.util.List;

public class TrainDetailResponse {
    private String trainID;
    private String trainName;
    private int trainType;
    private List<Steamer> steamerList;
    private MessageResponse error;

    public String getTrainID() {
        return trainID;
    }

    public void setTrainID(String trainID) {
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


    public List<Steamer> getSteamerList() {
        return steamerList;
    }

    public void setSteamerList(List<Steamer> steamerList) {
        this.steamerList = steamerList;
    }


    public MessageResponse getError() {
        return error;
    }

    public void setError(MessageResponse error) {
        this.error = error;
    }

    public TrainDetailResponse(String trainID, String trainName, int trainType, List<Steamer> steamerList, MessageResponse error) {
        this.trainID = trainID;
        this.trainName = trainName;
        this.trainType = trainType;
        this.steamerList = steamerList;
        this.error = error;
    }
}
