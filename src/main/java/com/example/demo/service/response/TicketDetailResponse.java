package com.example.demo.service.response;

import com.example.demo.model.Adminstraitor;
import com.example.demo.model.StationPerJourney;
import com.example.demo.model.Ticket;

import java.util.List;

public class TicketDetailResponse {
    private Ticket ticket;
    private MessageResponse error;
    private List<StationPerJourney> stationPerJourneys;
    private Adminstraitor adminstraitor;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }


    public MessageResponse getError() {
        return error;
    }

    public void setError(MessageResponse error) {
        this.error = error;
    }

    public List<StationPerJourney> getStationPerJourneys() {
        return stationPerJourneys;
    }

    public void setStationPerJourneys(List<StationPerJourney> stationPerJourneys) {
        this.stationPerJourneys = stationPerJourneys;
    }

    public Adminstraitor getAdminstraitor() {
        return adminstraitor;
    }

    public void setAdminstraitor(Adminstraitor adminstraitor) {
        this.adminstraitor = adminstraitor;
    }

    public TicketDetailResponse(Ticket ticket, MessageResponse error, List<StationPerJourney> stationPerJourneys, Adminstraitor adminstraitor) {
        this.ticket = ticket;
        this.error = error;
        this.stationPerJourneys = stationPerJourneys;
        this.adminstraitor = adminstraitor;
    }
}
