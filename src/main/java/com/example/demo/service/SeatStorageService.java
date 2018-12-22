package com.example.demo.service;

import com.example.demo.model.SeatStorage;
import com.example.demo.model.SeatStorageDeleteRequest;
import com.example.demo.service.response.SeatStorageResponse;

import java.util.List;

public interface SeatStorageService {
    SeatStorageResponse addSeatStorage(String username,SeatStorage seatStorage);
    SeatStorageResponse deleteSeatStorage(String username,SeatStorageDeleteRequest seatStorageDeleteRequest);
    SeatStorageResponse getSeatStorageByUserID(String username);
}
