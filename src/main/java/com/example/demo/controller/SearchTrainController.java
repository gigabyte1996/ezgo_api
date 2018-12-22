package com.example.demo.controller;


import com.example.demo.model.TrainRequest;
import com.example.demo.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

@PermitAll
@RestController
@RequestMapping("/api")
public class SearchTrainController {
    @Autowired
    private TrainService trainService;

    @PostMapping("train/search")
    public ResponseEntity searchTrain(@RequestBody TrainRequest requestTrain){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentUserName = authentication.getName();
        return new ResponseEntity<>(trainService.searchTrain(requestTrain), HttpStatus.OK);
    }
}
