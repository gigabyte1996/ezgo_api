package com.example.demo.model;

import java.util.Date;

public class Passenger {
    private String passengerName;
    private String ticketType;
    private String identificationNumber;
    private Date dateOfBirth;

    public Passenger() {
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Passenger(String passengerName, String ticketType, String identificationNumber, Date dateOfBirth) {
        this.passengerName = passengerName;
        this.ticketType = ticketType;
        this.identificationNumber = identificationNumber;
        this.dateOfBirth = dateOfBirth;
    }
}
