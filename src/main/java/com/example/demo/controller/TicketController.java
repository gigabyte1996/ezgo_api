package com.example.demo.controller;


import com.example.demo.model.Ticket;
import com.example.demo.model.TicketRequest;
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
    public ResponseEntity CreateTicket(@RequestBody TicketRequest ticketRequest){
        return  new ResponseEntity<>(ticketService.createTicket(ticketRequest), HttpStatus.CREATED);
    }


}
