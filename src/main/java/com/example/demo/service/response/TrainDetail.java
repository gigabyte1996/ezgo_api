package com.example.demo.service.response;

import com.example.demo.model.Steamer;

import java.util.List;

public class TrainDetail {
    private String trainID;
    private String trainNumber;
    private int trainType;
    private List<Steamer> steamerList;
    private MessageResponse messageResponse;

    public String getTrainID() {
        return trainID;
    }

    public void setTrainID(String trainID) {
        this.trainID = trainID;
    }

    public String getTrainName() {
        return trainNumber;
    }

    public void setTrainName(String trainName) {
        this.trainNumber = trainName;
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

    public MessageResponse getMessageResponse() {
        return messageResponse;
    }

    public void setMessageResponse(MessageResponse messageResponse) {
        this.messageResponse = messageResponse;
    }

    public TrainDetail(String trainID, String trainNumber, int trainType, List<Steamer> steamerList, MessageResponse messageResponse) {
        this.trainID = trainID;
        this.trainNumber = trainNumber;
        this.trainType = trainType;
        this.steamerList = steamerList;
        this.messageResponse = messageResponse;
    }
}
