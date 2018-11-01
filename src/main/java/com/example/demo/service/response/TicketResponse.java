package com.example.demo.service.response;

public class TicketResponse {
    private String ticketID;
    private String ticketCode;
    private MessageResponse error;

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public MessageResponse getError() {
        return error;
    }

    public void setError(MessageResponse error) {
        this.error = error;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public TicketResponse() {

        this.ticketID = ticketID;
        this.error = error;
        this.ticketCode = getTicketCode();
    }
}
