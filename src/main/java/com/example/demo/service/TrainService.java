package com.example.demo.service;


import com.example.demo.model.FilterRequest;
import com.example.demo.model.TrainRequest;
import com.example.demo.service.response.TrainDetailResponse;
import com.example.demo.service.response.TrainScheduleResponse;

public interface TrainService {
    TrainScheduleResponse searchTrain(TrainRequest requestTrain);

    TrainDetailResponse getTrainDiagrambyTrainId(Integer id);

    TrainScheduleResponse getTrainByFilter(FilterRequest filterRequest);
}
