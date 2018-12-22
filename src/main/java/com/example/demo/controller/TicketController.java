package com.example.demo.controller;


import com.example.demo.model.TicketRequest;
import com.example.demo.model.UserRequest;
import com.example.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("ticket/create")
    public ResponseEntity CreateTicket(@RequestBody List<TicketRequest> ticketRequestList){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        return  new ResponseEntity<>(ticketService.createTicket(currentUserName, ticketRequestList), HttpStatus.CREATED);
    }

    @GetMapping("ticket")
    public ResponseEntity getTicketByUserID(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        return new ResponseEntity<>(ticketService.getTicketByUserID(currentUserName), HttpStatus.OK);
    }

    @PostMapping("ticket/details")
    public ResponseEntity getTicketDetailsByTicketID(@RequestBody Integer ticketID){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        return new ResponseEntity<>(ticketService.getTicketDetailsByTicketID(currentUserName, ticketID), HttpStatus.OK);
    }

}
