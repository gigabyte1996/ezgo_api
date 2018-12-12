package com.example.demo.service.response;

import com.example.demo.model.Ticket;

import java.util.List;

public class TicketResponse {

    private List<Ticket> tickets;
    private MessageResponse error;

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public MessageResponse getError() {
        return error;
    }

    public void setError(MessageResponse error) {
        this.error = error;
    }

    public TicketResponse(List<Ticket> tickets, MessageResponse error) {
        this.tickets = tickets;
        this.error = error;
    }

    public TicketResponse() {
    }

}
