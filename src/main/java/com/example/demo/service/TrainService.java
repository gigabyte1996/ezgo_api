package com.example.demo.service;


import com.example.demo.model.FilterRequest;
import com.example.demo.model.TrainRequest;
import com.example.demo.service.response.TrainDetailResponse;
import com.example.demo.service.response.TrainScheduleResponse;

import java.util.ArrayList;

public interface TrainService {
    TrainScheduleResponse searchTrain(TrainRequest requestTrain);

//    TrainDetailResponse getTrainDiagrambyTrainId( ArrayList<Integer> trainIDs);

    TrainDetailResponse getTrainDiagrambyTrainScheduleId( Integer id);

    TrainScheduleResponse getTrainByFilter(FilterRequest filterRequest);
}
