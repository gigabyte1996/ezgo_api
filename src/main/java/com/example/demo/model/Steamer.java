package com.example.demo.model;

import java.util.List;

public class Steamer {
    private String steamerID;
    private int steamerNumber;
    private int steamerType;
    private boolean airCondition;
    private List<Seat> seatList;

    public String getSteamerID() {
        return steamerID;
    }

    public void setSteamerID(String steamerID) {
        this.steamerID = steamerID;
    }

    public int getSteamerNumber() {
        return steamerNumber;
    }

    public void setSteamerNumber(int steamerNumber) {
        this.steamerNumber = steamerNumber;
    }

    public int getSteamerType() {
        return steamerType;
    }

    public void setSteamerType(int steamerType) {
        this.steamerType = steamerType;
    }

    public boolean isAirCondition() {
        return airCondition;
    }

    public void setAirCondition(boolean airCondition) {
        this.airCondition = airCondition;
    }

//    public boolean isPantryCar() {
//        return pantryCar;
//    }
//
//    public void setPantryCar(boolean pantryCar) {
//        this.pantryCar = pantryCar;
//    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }
}
