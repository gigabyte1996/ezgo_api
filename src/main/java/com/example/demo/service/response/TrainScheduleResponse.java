package com.example.demo.service.response;

import com.example.demo.model.TrainSchedule;

import java.util.List;

public class TrainScheduleResponse {
    private List<TrainSchedule> trainSchedules;
    private MessageResponse error;

    public TrainScheduleResponse(List<TrainSchedule> trainSchedules, MessageResponse error) {
        this.trainSchedules = trainSchedules;
        this.error = error;
    }

    public List<TrainSchedule> getTrainSchedules() {
        return trainSchedules;
    }

    public void setTrainSchedules(List<TrainSchedule> trainSchedules) {
        this.trainSchedules = trainSchedules;
    }

    public MessageResponse getError() {
        return error;
    }

    public void setError(MessageResponse error) {
        this.error = error;
    }
}
