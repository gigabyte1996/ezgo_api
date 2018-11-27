package com.example.demo.service;

import com.example.demo.model.Ticket;
import com.example.demo.model.TicketRequest;
import com.example.demo.service.response.TicketResponse;

import java.util.List;

public interface TicketService {
    TicketResponse createTicket(TicketRequest ticketRequest);
}
