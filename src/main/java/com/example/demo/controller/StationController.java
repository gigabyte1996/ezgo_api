package com.example.demo.controller;

import com.example.demo.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StationController {
    @Autowired
    StationService stationService;

    @GetMapping("station")
    public ResponseEntity getListStation(){
        return new ResponseEntity<>(stationService.getListStation(), HttpStatus.OK);
    }


}
