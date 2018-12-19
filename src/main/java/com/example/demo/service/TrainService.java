package com.example.demo.service;


import com.example.demo.model.*;
import com.example.demo.service.response.SearchTrainResponse;
import com.example.demo.service.response.TrainDetailResponse;
import com.example.demo.service.response.TrainScheduleResponse;

import java.util.List;

public interface TrainService {
    TrainScheduleResponse searchTrain(TrainRequest requestTrain);

//    TrainDetailResponse getTrainDiagrambyTrainId( ArrayList<Integer> trainIDs);

    TrainDetailResponse getTrainDiagrambyTrainScheduleId( Integer id);

    TrainScheduleResponse getTrainByFilter(FilterRequest filterRequest);

    SearchTrainResponse searchTrainByName(Search searchTrain);

    TrainScheduleResponse sortByArrivaltime(List<TrainSchedule> trainSchedules);

//    TicketRequest test();
}
