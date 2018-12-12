package com.example.demo.model;

import java.util.List;

public class TicketRequest {
    SeatStorage seatStorage;
    Passenger passenger;

    public SeatStorage getSeatStorage() {
        return seatStorage;
    }

    public void setSeatStorage(SeatStorage seatStorage) {
        this.seatStorage = seatStorage;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public TicketRequest() {
    }

    public TicketRequest(SeatStorage seatStorage, Passenger passenger) {
        this.seatStorage = seatStorage;
        this.passenger = passenger;
    }
}
