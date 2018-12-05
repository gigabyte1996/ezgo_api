package com.example.demo.controller;


import com.example.demo.model.FilterRequest;
import com.example.demo.model.TrainRequest;
import com.example.demo.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @PostMapping("train/search")
    public ResponseEntity searchTrain(@RequestBody TrainRequest requestTrain){
        return new ResponseEntity<>(trainService.searchTrain(requestTrain), HttpStatus.OK);
    }

//    @PostMapping("train/diagram")
//    public ResponseEntity getTrainDiagrambyTrainId(@RequestBody ArrayList<Integer> trainIDs){
//        return new ResponseEntity<>(trainService.getTrainDiagrambyTrainId(trainIDs), HttpStatus.OK);
//    }

    @PostMapping("train/filter")
    public ResponseEntity getTrainByFilter(@RequestBody FilterRequest filterRequest){
        return new ResponseEntity<>(trainService.getTrainByFilter(filterRequest), HttpStatus.OK );

    }
    @PostMapping("train/diagram")
    public ResponseEntity getTrainDiagrambyTrainScheduleId(@RequestBody Integer trainScheduleID){
        return new ResponseEntity<>(trainService.getTrainDiagrambyTrainScheduleId(trainScheduleID), HttpStatus.OK);
    }

}
