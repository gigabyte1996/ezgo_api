package com.example.demo.model;

import java.util.Date;

public class TrainSchedule {
    private String trainScheduleID;
    private String jouneyName;
    private Date departureTime;
    private Date arrivalTime;
    private String firstStation;
    private String lastStation;
    private String trainID;

    public String getTrainScheduleID() {
        return trainScheduleID;
    }

    public void setTrainScheduleID(String trainScheduleID) {
        this.trainScheduleID = trainScheduleID;
    }

    public String getJouneyName() {
        return jouneyName;
    }

    public void setJouneyName(String jouneyName) {
        this.jouneyName = jouneyName;
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

    public String getFirstStation() {
        return firstStation;
    }

    public void setFirstStation(String firstStation) {
        this.firstStation = firstStation;
    }

    public String getLastStation() {
        return lastStation;
    }

    public void setLastStation(String lastStation) {
        this.lastStation = lastStation;
    }

    public String getTrainID() {
        return trainID;
    }

    public void setTrainID(String trainID) {
        this.trainID = trainID;
    }
}
