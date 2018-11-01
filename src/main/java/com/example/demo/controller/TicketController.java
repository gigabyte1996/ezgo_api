package com.example.demo.controller;


import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("ticket/create")
    public ResponseEntity CreateTicket(@RequestBody Ticket ticket){
        return  new ResponseEntity<>(ticketService.createTicket(ticket), HttpStatus.CREATED);
    }


}
