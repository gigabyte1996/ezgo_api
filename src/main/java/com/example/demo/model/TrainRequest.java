package com.example.demo.model;

import java.util.Date;

public class TrainRequest {
    private String fromStation;
    private String toStation;
    private Date departureTime;
    private Date returnTime;

    public TrainRequest() {
        super();
    }

    public String getFromStation() {
        return fromStation;
    }

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

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public TrainRequest(String fromStation, String toStation, Date departureTime, Date returnTime) {
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.departureTime = departureTime;
        this.returnTime = returnTime;
    }
}
