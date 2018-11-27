package com.example.demo.model;

import java.util.List;

public class Steamer {
    private Integer steamerID;
    private Integer steamerNumber;
    private Integer steamerType;
    private boolean airCondition;
    private List<Seat> seatList;

    public Integer getSteamerID() {
        return steamerID;
    }

    public void setSteamerID(Integer steamerID) {
        this.steamerID = steamerID;
    }

    public Integer getSteamerNumber() {
        return steamerNumber;
    }

    public void setSteamerNumber(Integer steamerNumber) {
        this.steamerNumber = steamerNumber;
    }

    public Integer getSteamerType() {
        return steamerType;
    }

    public void setSteamerType(Integer steamerType) {
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
