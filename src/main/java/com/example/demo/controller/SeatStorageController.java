package com.example.demo.controller;


import com.example.demo.model.SeatStorage;
import com.example.demo.model.SeatStorageDeleteRequest;
import com.example.demo.service.SeatStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SeatStorageController {

    @Autowired
    SeatStorageService seatStorageService;


    @PostMapping("seatStorage/add")
    public ResponseEntity addSeatStorage(@RequestBody SeatStorage seatStorage){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        return new ResponseEntity<>(seatStorageService.addSeatStorage(currentUserName, seatStorage), HttpStatus.OK);
    }

    @DeleteMapping("seatStorage")
    public ResponseEntity deleteSeatStorage(@RequestBody SeatStorageDeleteRequest seatStorageDeleteRequest){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        return new ResponseEntity<>(seatStorageService.deleteSeatStorage(currentUserName, seatStorageDeleteRequest), HttpStatus.OK);
    }

    @GetMapping("seatStorage")
    public ResponseEntity getSeatStorage(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        return new ResponseEntity<>(seatStorageService.getSeatStorageByUserID( currentUserName), HttpStatus.OK);
    }

}
