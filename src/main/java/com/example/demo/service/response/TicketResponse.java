package com.example.demo.service.response;

import com.example.demo.model.Ticket;

import java.util.List;

public class TicketResponse {

    private List<TicketDetailResponse> ticketDetailResponses;
    private MessageResponse error;

    public List<TicketDetailResponse> getTicketDetailResponses() {
        return ticketDetailResponses;
    }

    public void setTicketDetailResponses(List<TicketDetailResponse> ticketDetailResponses) {
        this.ticketDetailResponses = ticketDetailResponses;
    }

    public MessageResponse getError() {
        return error;
    }

    public void setError(MessageResponse error) {
        this.error = error;
    }

    public TicketResponse(List<TicketDetailResponse> ticketDetailResponses, MessageResponse error) {
        this.ticketDetailResponses = ticketDetailResponses;
        this.error = error;
    }

    public TicketResponse() {
    }

}
