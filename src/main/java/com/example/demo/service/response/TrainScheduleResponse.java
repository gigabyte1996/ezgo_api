package com.example.demo.service.response;

import com.example.demo.model.TrainSchedule;

import java.util.List;

public class TrainScheduleResponse {
    private List<TrainSchedule> SingleTrainSchedules;
    private List<TrainSchedule> ReturnTrainSchedules;
    private MessageResponse error;

    public TrainScheduleResponse() {
    }

    public TrainScheduleResponse(List<TrainSchedule> singleTrainSchedules, List<TrainSchedule> returnTrainSchedules, MessageResponse error) {
        SingleTrainSchedules = singleTrainSchedules;
        ReturnTrainSchedules = returnTrainSchedules;
        this.error = error;
    }

    public List<TrainSchedule> getSingleTrainSchedules() {
        return SingleTrainSchedules;
    }

    public void setSingleTrainSchedules(List<TrainSchedule> singleTrainSchedules) {
        SingleTrainSchedules = singleTrainSchedules;
    }

    public List<TrainSchedule> getReturnTrainSchedules() {
        return ReturnTrainSchedules;
    }

    public void setReturnTrainSchedules(List<TrainSchedule> returnTrainSchedules) {
        ReturnTrainSchedules = returnTrainSchedules;
    }

    public MessageResponse getError() {
        return error;
    }

    public void setError(MessageResponse error) {
        this.error = error;
    }
}
