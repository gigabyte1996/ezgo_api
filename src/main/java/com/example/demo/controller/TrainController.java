package com.example.demo.controller;


import com.example.demo.model.*;
import com.example.demo.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @PostMapping
    public ResponseEntity searchTrainByName(@RequestBody Search searchTrain){
        return new ResponseEntity<>(trainService.searchTrainByName(searchTrain), HttpStatus.OK);
    }

//    @PostMapping
//    public  ResponseEntity sortByArrivaltime(@RequestBody List<TrainSchedule> trainSchedules ){
//        return new ResponseEntity<>(trainService.sortByArrivaltime(trainSchedules), HttpStatus.OK);
//    }

    @GetMapping("train/test")
    public ResponseEntity test(){
        List<TicketRequest> ticketRequests = new ArrayList<>();
        SeatStorage seatStorage = new SeatStorage(1, 1,1,1,"a","a","a","a",null,1,1,1,1,20000);
        Passenger passenger = new Passenger("a","a","a",null);
        TicketRequest ticketRequest = new TicketRequest(seatStorage,passenger);
        ticketRequests.add(ticketRequest);
        ticketRequests.add(ticketRequest);
        return new ResponseEntity<>(ticketRequests, HttpStatus.OK);
    }

}
