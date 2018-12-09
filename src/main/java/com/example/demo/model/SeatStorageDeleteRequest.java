package com.example.demo.model;

public class SeatStorageDeleteRequest {
    private Integer seatID;
    private Integer trainScheduleID;

    public Integer getSeatID() {
        return seatID;
    }

    public void setSeatID(Integer seatID) {
        this.seatID = seatID;
    }

    public Integer getTrainScheduleID() {
        return trainScheduleID;
    }

    public void setTrainScheduleID(Integer trainScheduleID) {
        this.trainScheduleID = trainScheduleID;
    }

    public SeatStorageDeleteRequest(Integer seatID, Integer trainScheduleID) {
        this.seatID = seatID;
        this.trainScheduleID = trainScheduleID;
    }

    public SeatStorageDeleteRequest() {
    }
}
