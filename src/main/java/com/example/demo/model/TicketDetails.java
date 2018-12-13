package com.example.demo.model;

import java.util.List;

public class TicketDetails {
    Ticket ticket;
    List<TrainSchedule> trainSchedules;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public List<TrainSchedule> getTrainSchedules() {
        return trainSchedules;
    }

    public void setTrainSchedules(List<TrainSchedule> trainSchedules) {
        this.trainSchedules = trainSchedules;
    }

    public TicketDetails(Ticket ticket, List<TrainSchedule> trainSchedules) {
        this.ticket = ticket;
        this.trainSchedules = trainSchedules;
    }
}
