package com.example.demo.service;


import com.example.demo.entity.SeatEntity;
import com.example.demo.entity.SteamerEntity;
import com.example.demo.entity.TrainEntity;
import com.example.demo.entity.TrainScheduleEntity;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.response.MessageResponse;
import com.example.demo.service.response.SearchTrainResponse;
import com.example.demo.service.response.TrainDetailResponse;
import com.example.demo.service.response.TrainScheduleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainScheduleRepository trainScheduleRepository;

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private SteamerRepository steamerRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private SeatStatusRepository seatStatusRepository;

    @Autowired
    private CarrageFareRepository carrageFareRepository;

    @Override
    public TrainScheduleResponse searchTrain(TrainRequest requestTrain) {
        MessageResponse messageResponse = new MessageResponse(0, "Success");
        List<TrainSchedule> trainScheduleList = new ArrayList<>();
        List<TrainSchedule> trainScheduleList1 = new ArrayList<>();
        TrainScheduleResponse trainScheduleResponse = new TrainScheduleResponse();

        if (requestTrain.getDepartureTime() == null) {

            trainScheduleList = findSchedule(requestTrain.getToStation(), requestTrain.getFromStation(), requestTrain.getReturnTime());
            trainScheduleResponse = new TrainScheduleResponse(trainScheduleList, null, messageResponse);

        } else if (requestTrain.getReturnTime() == null) {

            trainScheduleList = findSchedule(requestTrain.getFromStation(), requestTrain.getToStation(), requestTrain.getDepartureTime());
            trainScheduleResponse = new TrainScheduleResponse(trainScheduleList, null, messageResponse);

        } else {
            trainScheduleList = findSchedule(requestTrain.getFromStation(), requestTrain.getToStation(), requestTrain.getDepartureTime());
            trainScheduleList1 = findSchedule(requestTrain.getToStation(), requestTrain.getFromStation(), requestTrain.getReturnTime());
            trainScheduleResponse = new TrainScheduleResponse(trainScheduleList, trainScheduleList1, messageResponse);

        }
        return trainScheduleResponse;
    }


    @Override
    public TrainDetailResponse getTrainDiagrambyTrainScheduleId(Integer id) {
        Integer trainID = trainScheduleRepository.findTrainScheduleEntityByTrainScheduleID(id).getTrainEntity().getTrainID();
        TrainEntity trainEntity = trainRepository.findTrainEntityByTrainID(trainID);
        List<SteamerEntity> steamerEntities = steamerRepository.findSteamerEntitiesByTrainEntity_TrainID(trainID);
        List<Steamer> steamers = new ArrayList<>();
        Train train = parseTrainEntityToTrainModel(trainEntity);
        MessageResponse messageResponse = new MessageResponse(0,"Success");
        for (SteamerEntity steamerEntity : steamerEntities) {
            List<SeatEntity> seatEntities =  seatRepository.findSeatEntitiesBySteamerEntity_SteamerID(steamerEntity.getSteamerID());
            List<Seat> seats = new ArrayList<>();
            for (SeatEntity seatEntity : seatEntities){
                Seat seat = parseSeatEntityToSeatModel(seatEntity, id);
                seats.add(seat);
            }
            Steamer steamer = parseSteamerEntityToSteamerModel(steamerEntity, id);
            steamers.add(steamer);
        }
        TrainDetailResponse trainDetailResponse = new TrainDetailResponse(train.getTrainID(), train.getTrainName(), train.getTrainType(), steamers,messageResponse  );
        return trainDetailResponse;
    }

    private List<Steamer> parseListSteamerEntitiesToListSteamerModel(List<SteamerEntity> steamerEntities, Integer trainScheduleID) {
        List<Steamer> steamerList = new ArrayList<>();
        for (SteamerEntity item : steamerEntities){
            steamerList.add(parseSteamerEntityToSteamerModel(item, trainScheduleID));
        }
        return steamerList;
    }

    private Seat parseSeatEntityToSeatModel(SeatEntity seatEntity, Integer trainCheduleID) {
        Seat seat = new Seat();
        seat.setSeatID(seatEntity.getSeatID());
        seat.setSeatNumber(seatEntity.getSeatNumber());
        seat.setSeatType(seatEntity.getSeatType());
        seat.setSeatStatus(seatStatusRepository.findSeatStatusEntityByTrainScheduleEntity_TrainScheduleIDAndAndSeatEntity_SeatID(trainCheduleID,seatEntity.getSeatID()).getSeatStatus());
        return seat;
    }

    private List<TrainSchedule> findSchedule(String fromStation, String toStation, Date departuretime) {
        List<TrainSchedule> trainScheduleList = new ArrayList<>();
        List<TrainScheduleEntity> trainScheduleEntities = trainScheduleRepository.findAll();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (TrainScheduleEntity item : trainScheduleEntities) {
            if (item.getFirstStation().getStationName().equals(fromStation)
                    && item.getLastStation().getStationName().equals(toStation)
                    && sdf.format(item.getDepartureTime()).equals(sdf.format(departuretime))) {
                trainScheduleList.add(parseTrainScheduleEntityToTrainSchdeduleModel(item));
            }
        }
        return trainScheduleList;
    }

    @Override
    public TrainScheduleResponse getTrainByFilter(FilterRequest filterRequest) {
        List<TrainScheduleEntity> trainScheduleEntities = trainScheduleRepository.findAll();
        return null;
    }

    @Override
    public SearchTrainResponse searchTrainByName(SearchTrain searchTrain) {
        TrainScheduleEntity trainScheduleEntity = new TrainScheduleEntity();
        trainScheduleEntity = trainScheduleRepository.findTrainScheduleEntityByTrainScheduleCode(searchTrain.getTrainScheduleCode());
        TrainSchedule trainSchedule = parseTrainScheduleEntityToTrainSchdeduleModel(trainScheduleEntity);
        MessageResponse messageResponse = new MessageResponse(0, "Success");
        return new SearchTrainResponse(trainSchedule, messageResponse);
    }

    private Steamer parseSteamerEntityToSteamerModel(SteamerEntity steamerEntity, Integer trainScheduleID) {
        Steamer steamer = new Steamer();
        steamer.setSteamerID(steamerEntity.getSteamerID());
        steamer.setSteamerNumber(steamerEntity.getSteamerNumber());
        steamer.setSteamerType(steamerEntity.getSteamerType());
        steamer.setAirCondition(steamerEntity.isAirCondition());
//        steamer.setPantryCar(steamerEntity.isPantryCar());
        steamer.setSeatList(parseListSeatEntityToListSeatModel(steamerEntity.getSeatEntities(), trainScheduleID));
        steamer.setSteamerFare(carrageFareRepository.findCarrageFareEntityBySteamerEntity_SteamerIDAndTrainScheduleEntity_TrainScheduleID(steamerEntity.getSteamerID(),trainScheduleID).getCarrageFare());
        return steamer;
    }

    private List<Seat> parseListSeatEntityToListSeatModel(List<SeatEntity> seatEntities, Integer trainScheduleID) {
        List<Seat> seatList = new ArrayList<>();
        for (SeatEntity seatEntity : seatEntities) {
            seatList.add(parseSeatEntityToSeatModel(seatEntity, trainScheduleID));
        }
        return seatList;
    }


    private Train parseTrainEntityToTrainModel(TrainEntity trainEntity) {
        Train train = new Train();
        train.setTrainID(trainEntity.getTrainID());
//        train.setTrainNumber(trainEntity.getTrainNumber());
        train.setTrainName(trainEntity.getTrainName());
        train.setTrainType(trainEntity.getTrainType());
        train.setPantryCar(trainEntity.isPantryCar());
        return train;
    }

    private TrainSchedule parseTrainScheduleEntityToTrainSchdeduleModel(TrainScheduleEntity trainScheduleEntity) {
        TrainSchedule trainSchedule = new TrainSchedule();
        trainSchedule.setTrainScheduleID(trainScheduleEntity.getTrainScheduleID());
        trainSchedule.setTrainName(trainScheduleEntity.getTrainEntity().getTrainName());
        trainSchedule.setFirstStation(trainScheduleEntity.getFirstStation().getStationName());
        trainSchedule.setLastStation(trainScheduleEntity.getLastStation().getStationName());
        trainSchedule.setJouneyName(trainScheduleEntity.getJouneyName());
        trainSchedule.setDepartureTime(trainScheduleEntity.getDepartureTime());
        trainSchedule.setArrivalTime(trainScheduleEntity.getArrivalTime());
        trainSchedule.setTrainID(trainScheduleEntity.getTrainEntity().getTrainID());
        trainSchedule.setTrainScheduleCode(trainScheduleEntity.getTrainScheduleCode());
        return trainSchedule;
    }


}
