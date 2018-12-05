package com.example.demo.service.response;

import com.example.demo.model.Steamer;
import com.example.demo.model.Train;
import com.example.demo.model.TrainDetail;

import java.util.List;

public class TrainDetailResponse {
//    private List<TrainDetail> trainDetails;
//    private MessageResponse error;

        private Integer trainID;
        private String trainName;
        private Integer trainType;
        private List<Steamer> steamerList;
        private MessageResponse error;

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

    public TrainDetailResponse(Integer trainID, String trainName, Integer trainType, List<Steamer> steamerList, MessageResponse error) {
        this.trainID = trainID;
        this.trainName = trainName;
        this.trainType = trainType;
        this.steamerList = steamerList;
        this.error = error;
    }
}
