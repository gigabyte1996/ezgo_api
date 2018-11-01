package com.example.demo.model;

public class FilterRequest {
    private int pantryCar;
    private int airCondition;
    private SeatType seatType;
    private TrainType trainType;
    private DepartureTime departureTime;

    public FilterRequest() {
        super();
    }

    public FilterRequest(int pantryCar, int airCondition, SeatType seatType, TrainType trainType, DepartureTime departureTime) {
        this.pantryCar = pantryCar;
        this.airCondition = airCondition;
        this.seatType = seatType;
        this.trainType = trainType;
        this.departureTime = departureTime;
    }

    public int getPantryCar() {
        return pantryCar;
    }

    public void setPantryCar(int pantryCar) {
        this.pantryCar = pantryCar;
    }

    public int getAirCondition() {
        return airCondition;
    }

    public void setAirCondition(int airCondition) {
        this.airCondition = airCondition;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public TrainType getTrainType() {
        return trainType;
    }

    public void setTrainType(TrainType trainType) {
        this.trainType = trainType;
    }

    public DepartureTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(DepartureTime departureTime) {
        this.departureTime = departureTime;
    }
}
