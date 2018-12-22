package com.example.demo.service;

import com.example.demo.constant.HTTPCodeResponse;
import com.example.demo.constant.SeatStatus;
import com.example.demo.entity.SeatEntity;
import com.example.demo.entity.SeatStatusEntity;
import com.example.demo.entity.SeatStorageEntity;
import com.example.demo.model.SeatStorage;
import com.example.demo.model.SeatStorageDeleteRequest;
import com.example.demo.repository.SeatRepository;
import com.example.demo.repository.SeatStatusRepository;
import com.example.demo.repository.SeatStorageRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.response.MessageResponse;
import com.example.demo.service.response.SeatStorageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatStorageServiceImpl implements SeatStorageService {

    @Autowired
    SeatStorageRepository seatStorageRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SeatStatusRepository seatStatusRepository;


    @Override
    public SeatStorageResponse addSeatStorage(String username, SeatStorage seatStorage) {
        SeatStorageEntity seatStorageEntity = new SeatStorageEntity();
        SeatStatusEntity seatStatusEntity = new SeatStatusEntity();

        seatStorageEntity.setUserEntity(userRepository.findUserEntityByUserID(seatStorage.getUserID()));
        seatStorageEntity.setTrainName(seatStorage.getTrainName());
        seatStorageEntity.setScheduleName(seatStorage.getScheduleName());
        seatStorageEntity.setDepartureTime(seatStorage.getDepartureTime());
        seatStorageEntity.setCarrageNumber(seatStorage.getCarrageNumber());
        seatStorageEntity.setSeatNumber(seatStorage.getSeatNumber());
        seatStorageEntity.setCarrageType(seatStorage.getCarrageType());
        seatStorageEntity.setSeatLocation(seatStorage.getSeatLocation());
        seatStorageEntity.setFare(seatStorage.getFare());
        seatStorageEntity.setTrainScheduleID(seatStorage.getTrainScheduleID());
        seatStorageEntity.setSeatID(seatStorage.getSeatID());
        seatStorageEntity.setToStation(seatStorage.getToStation());
        seatStorageEntity.setFromStation(seatStorage.getFromStation());
        seatStorageRepository.save(seatStorageEntity);
        seatStatusEntity = seatStatusRepository.findSeatStatusEntityByTrainScheduleEntity_TrainScheduleIDAndAndSeatEntity_SeatID(seatStorage.getTrainScheduleID(), seatStorage.getSeatID());
        seatStatusEntity.setSeatStatus(SeatStatus.PICKING);
        seatStatusRepository.save(seatStatusEntity);

        List<SeatStorageEntity> seatStorageEntities = new ArrayList<>();
        if (seatStorageRepository.findSeatStorageEntitiesByUserEntity_UserID(seatStorage.getUserID())!= null){
            seatStorageEntities = seatStorageRepository.findSeatStorageEntitiesByUserEntity_UserID(seatStorage.getUserID());
        }
        List<SeatStorage> seatStorageList = parseListSeatStorageEntityToListSeatStogare(seatStorageEntities);
        MessageResponse messageResponse = new MessageResponse(0,"Success");
        SeatStorageResponse seatStorageResponse = new SeatStorageResponse(seatStorageList, messageResponse);

        return seatStorageResponse;
    }

    @Override
    public SeatStorageResponse deleteSeatStorage(String username,SeatStorageDeleteRequest seatStorageDeleteRequest) {
        SeatStatusEntity seatStatusEntity = new SeatStatusEntity();
        List<SeatStorage> seatStorageList = new ArrayList<>();
        SeatStorageEntity seatStorageEntity = new SeatStorageEntity();
        seatStorageEntity = seatStorageRepository.findSeatStorageEntityBySeatIDAndTrainScheduleID(seatStorageDeleteRequest.getSeatID(), seatStorageDeleteRequest.getTrainScheduleID());
        seatStatusEntity = seatStatusRepository.findSeatStatusEntityByTrainScheduleEntity_TrainScheduleIDAndAndSeatEntity_SeatID(seatStorageEntity.getTrainScheduleID(), seatStorageEntity.getSeatID());
        seatStatusEntity.setSeatStatus(SeatStatus.EMPTY);

        seatStorageRepository.deleteById(seatStorageEntity.getSeatStorageID());
        List<SeatStorageEntity> seatStorageEntities = seatStorageRepository.findAll();
        seatStorageList = parseListSeatStorageEntityToListSeatStogare(seatStorageEntities);

        MessageResponse messageResponse = new MessageResponse(HTTPCodeResponse.SUCCESS, "Success");
        SeatStorageResponse seatStorageResponse = new SeatStorageResponse(seatStorageList, messageResponse);
        return seatStorageResponse;
    }

    @Override
    public SeatStorageResponse getSeatStorageByUserID(String username) {
        List<SeatStorage> seatStorageList = new ArrayList<>();
        MessageResponse messageResponse = new MessageResponse();
        List<SeatStorageEntity> seatStorageEntities = seatStorageRepository.findSeatStorageEntitiesByUserEntity_UserID(Integer.parseInt(username));
        if (seatStorageEntities != null) {
            seatStorageList = parseListSeatStorageEntityToListSeatStogare(seatStorageEntities);
            messageResponse = new MessageResponse(0, "success");
        }
        SeatStorageResponse seatStorageResponse = new SeatStorageResponse(seatStorageList, messageResponse);
        return seatStorageResponse;
    }

    private List<SeatStorage> parseListSeatStorageEntityToListSeatStogare(List<SeatStorageEntity> seatStorageEntities) {
        List<SeatStorage> seatStorageList = new ArrayList<>();
        SeatStorage seatStorage = new SeatStorage();
        for (SeatStorageEntity item : seatStorageEntities){
            seatStorage = parseSeatStorageEntityToSeatStogare(item);
            seatStorageList.add(seatStorage);
        }
        return seatStorageList;
    }

    public SeatStorage parseSeatStorageEntityToSeatStogare(SeatStorageEntity seatStorageEntity){
        SeatStorage seatStorage = new SeatStorage();
        seatStorage.setUserID(seatStorageEntity.getUserEntity().getUserID());
        seatStorage.setSeatStorageID(seatStorageEntity.getSeatStorageID());
        seatStorage.setTrainName(seatStorageEntity.getTrainName());
        seatStorage.setScheduleName(seatStorageEntity.getScheduleName());
        seatStorage.setToStation(seatStorageEntity.getToStation());
        seatStorage.setFromStation(seatStorageEntity.getFromStation());
        seatStorage.setDepartureTime(seatStorageEntity.getDepartureTime());
        seatStorage.setCarrageNumber(seatStorageEntity.getCarrageNumber());
        seatStorage.setCarrageType(seatStorageEntity.getCarrageType());
        seatStorage.setSeatNumber(seatStorageEntity.getSeatNumber());
        seatStorage.setSeatLocation(seatStorageEntity.getSeatLocation());
        seatStorage.setFare(seatStorageEntity.getFare());
        seatStorage.setSeatID(seatStorageEntity.getSeatID());
        seatStorage.setTrainScheduleID(seatStorageEntity.getTrainScheduleID());
        return seatStorage;

    }
}
