package com.example.demo.service.response;

import com.example.demo.model.SeatStorage;

import java.util.List;

public class SeatStorageResponse {
    private List<SeatStorage> seatStorageList;
    private MessageResponse error;

    public SeatStorageResponse() {
    }

    public List<SeatStorage> getSeatStorageList() {
        return seatStorageList;
    }

    public void setSeatStorageList(List<SeatStorage> seatStorageList) {
        this.seatStorageList = seatStorageList;
    }

    public MessageResponse getError() {
        return error;
    }

    public void setError(MessageResponse error) {
        this.error = error;
    }

    public SeatStorageResponse(List<SeatStorage> seatStorageList, MessageResponse error) {
        this.seatStorageList = seatStorageList;
        this.error = error;
    }
}
