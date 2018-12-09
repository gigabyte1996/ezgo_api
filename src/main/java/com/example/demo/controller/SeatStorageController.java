package com.example.demo.controller;


import com.example.demo.model.SeatStorage;
import com.example.demo.model.SeatStorageDeleteRequest;
import com.example.demo.service.SeatStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SeatStorageController {

    @Autowired
    SeatStorageService seatStorageService;


    @PostMapping("seatStorage/add")
    public ResponseEntity addSeatStorage(@RequestBody SeatStorage seatStorage){
        return new ResponseEntity<>(seatStorageService.addSeatStorage(seatStorage), HttpStatus.OK);
    }

    @DeleteMapping("seatStorage")
    public ResponseEntity deleteSeatStorage(@RequestBody SeatStorageDeleteRequest seatStorageDeleteRequest){
        return new ResponseEntity<>(seatStorageService.deleteSeatStorage(seatStorageDeleteRequest), HttpStatus.OK);
    }

    @PostMapping("seatStorage")
    public ResponseEntity getSeatStorage(@RequestBody Integer userID){
        return new ResponseEntity<>(seatStorageService.getSeatStorageByUserID(userID), HttpStatus.OK);
    }

}
