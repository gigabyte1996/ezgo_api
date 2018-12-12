package com.example.demo.service.response;

import com.example.demo.model.TrainSchedule;

import java.util.List;

public class SearchTrainResponse {
    private TrainSchedule trainSchedule;
    private MessageResponse error;

    public TrainSchedule getTrainSchedule() {
        return trainSchedule;
    }

    public void setTrainSchedule(TrainSchedule trainSchedule) {
        this.trainSchedule = trainSchedule;
    }

    public MessageResponse getError() {
        return error;
    }

    public void setError(MessageResponse error) {
        this.error = error;
    }

    public SearchTrainResponse(TrainSchedule trainSchedule, MessageResponse error) {
        this.trainSchedule = trainSchedule;
        this.error = error;
    }
}
