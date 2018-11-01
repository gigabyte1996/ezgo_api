package com.example.demo.service;

import com.example.demo.model.Ticket;
import com.example.demo.service.response.TicketResponse;

public interface TicketService {
    TicketResponse createTicket(Ticket ticket);
}
