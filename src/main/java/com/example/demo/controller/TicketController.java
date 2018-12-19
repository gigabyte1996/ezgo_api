package com.example.demo.controller;


import com.example.demo.model.TicketRequest;
import com.example.demo.model.UserRequest;
import com.example.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("ticket/create")
    public ResponseEntity CreateTicket(@RequestBody List<TicketRequest> ticketRequestList){
        return  new ResponseEntity<>(ticketService.createTicket(ticketRequestList), HttpStatus.CREATED);
    }

    @GetMapping("ticket")
    public ResponseEntity getTicketByUserID(@RequestBody UserRequest userRequest){
        return new ResponseEntity<>(ticketService.getTicketByUserID(userRequest), HttpStatus.OK);
    }

    @PostMapping("ticket/details")
    public ResponseEntity getTicketDetailsByTicketID(@RequestBody Integer ticketID){
        return new ResponseEntity<>(ticketService.getTicketDetailsByTicketID(ticketID), HttpStatus.OK);
    }

}
