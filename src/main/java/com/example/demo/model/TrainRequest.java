package com.example.demo.model;

import java.util.Date;

public class TrainRequest {
    private String fromStation;
    private String toStation;
    private Date departureTime;
    private Date arrivalTime;

    public TrainRequest() {
        super();
    }

    public TrainRequest(String fromStation, String toStation, Date departureTime, Date arrivalTime) {
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public String getFromStation() { return fromStation; }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
