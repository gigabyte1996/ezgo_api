package com.example.demo.service;

import com.example.demo.model.Search;
import com.example.demo.service.response.TrainScheduleResponse;



public interface SearchService {
    TrainScheduleResponse searchTrainScheduleByCode(String username, Search search);
}
