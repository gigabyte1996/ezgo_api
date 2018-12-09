package com.example.demo.service;

import com.example.demo.model.SeatStorage;
import com.example.demo.model.SeatStorageDeleteRequest;
import com.example.demo.service.response.SeatStorageResponse;

import java.util.List;

public interface SeatStorageService {
    SeatStorageResponse addSeatStorage(SeatStorage seatStorage);
    SeatStorageResponse deleteSeatStorage(SeatStorageDeleteRequest seatStorageDeleteRequest);
    SeatStorageResponse getSeatStorageByUserID(Integer userID);
}
