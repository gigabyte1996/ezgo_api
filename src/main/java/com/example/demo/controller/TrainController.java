package com.example.demo.controller;


import com.example.demo.model.*;
import com.example.demo.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.ArrayList;
import java.util.List;

@PermitAll
@RestController
@RequestMapping("/api")
public class TrainController {

    @Autowired
    private TrainService trainService;

//    @PostMapping("train/search")
//    public ResponseEntity searchTrain(@RequestBody TrainRequest requestTrain){
////        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
////        String currentUserName = authentication.getName();
//        return new ResponseEntity<>(trainService.searchTrain(requestTrain), HttpStatus.OK);
//    }

//    @PostMapping("train/diagram")
//    public ResponseEntity getTrainDiagrambyTrainId(@RequestBody ArrayList<Integer> trainIDs){
//        return new ResponseEntity<>(trainService.getTrainDiagrambyTrainId(trainIDs), HttpStatus.OK);
//    }

    @PostMapping("train/filter")
    public ResponseEntity getTrainByFilter(@RequestBody FilterRequest filterRequest){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        return new ResponseEntity<>(trainService.getTrainByFilter(currentUserName, filterRequest), HttpStatus.OK );

    }
    @PostMapping("train/diagram")
    public ResponseEntity getTrainDiagrambyTrainScheduleId(@RequestBody Integer trainScheduleID){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        return new ResponseEntity<>(trainService.getTrainDiagrambyTrainScheduleId(currentUserName, trainScheduleID), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity searchTrainByName(@RequestBody Search searchTrain){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        return new ResponseEntity<>(trainService.searchTrainByName(currentUserName, searchTrain), HttpStatus.OK);
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
