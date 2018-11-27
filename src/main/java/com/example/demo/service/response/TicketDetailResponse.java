package com.example.demo.service.response;

import com.example.demo.model.Ticket;

import java.util.List;

public class TicketDetailResponse {
    private Ticket ticket;
    private String ticketCode;

    public TicketDetailResponse(Ticket ticket, String ticketCode) {
        this.ticket = ticket;
        this.ticketCode = ticketCode;
    }

    public TicketDetailResponse() {
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }
}
