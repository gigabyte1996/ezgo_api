package com.example.demo.service;


import com.example.demo.model.FilterRequest;
import com.example.demo.model.TrainRequest;
import com.example.demo.service.response.TrainDetail;
import com.example.demo.service.response.TrainScheduleResponse;

public interface TrainService {
    TrainScheduleResponse searchTrain(TrainRequest requestTrain);

    TrainDetail getTrainDiagrambyTrainId(String id);

    TrainScheduleResponse getTrainByFilter(FilterRequest filterRequest);
}
