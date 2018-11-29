package com.example.demo.service;


import com.example.demo.entity.SeatEntity;
import com.example.demo.entity.SteamerEntity;
import com.example.demo.entity.TrainEntity;
import com.example.demo.entity.TrainScheduleEntity;
import com.example.demo.model.*;
import com.example.demo.repository.SeatRepository;
import com.example.demo.repository.SteamerRepository;
import com.example.demo.repository.TrainRepository;
import com.example.demo.repository.TrainScheduleRepository;
import com.example.demo.service.response.MessageResponse;
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
    public TrainDetailResponse getTrainDiagrambyTrainId(Integer id) {
//        id = id.substring(1, id.length() - 1);
        TrainEntity trainEntity = trainRepository.findTrainEntityByTrainID(id);
        List<SteamerEntity> steamerEntities = steamerRepository.findSteamerEntitiesByTrainEntity_TrainID(id);
        List<Steamer> steamers = new ArrayList<>();
        Train train = parseTrainEntityToTrainModel(trainEntity);
        MessageResponse messageResponse = new MessageResponse(0, "Success");
        for (SteamerEntity steamerEntity : steamerEntities) {
            List<SeatEntity> seatEntities = seatRepository.findSeatEntitiesBySteamerEntity_SteamerID(steamerEntity.getSteamerID());
            List<Seat> seats = new ArrayList<>();
            for (SeatEntity seatEntity : seatEntities) {
                Seat seat = parseSeatEntityToSeatModel(seatEntity);
                seats.add(seat);
            }
            Steamer steamer = parseSteamerEntityToSteamerModel(steamerEntity);
            steamers.add(steamer);
        }
        TrainDetailResponse trainDetailResponse = new TrainDetailResponse(train.getTrainID(), train.getTrainName(), train.getTrainType(), steamers, messageResponse);
        return trainDetailResponse;
    }

    private Seat parseSeatEntityToSeatModel(SeatEntity seatEntity) {
        Seat seat = new Seat();
        seat.setSeatID(seatEntity.getSeatID());
        seat.setSeatNumber(seatEntity.getSeatNumber());
        seat.setSeatType(seatEntity.getSeatType());
        seat.setSeatStatus(seatEntity.getSeatStatus());
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

    private Steamer parseSteamerEntityToSteamerModel(SteamerEntity steamerEntity) {
        Steamer steamer = new Steamer();
        steamer.setSteamerID(steamerEntity.getSteamerID());
        steamer.setSteamerNumber(steamerEntity.getSteamerNumber());
        steamer.setSteamerType(steamerEntity.getSteamerType());
        steamer.setAirCondition(steamerEntity.isAirCondition());
//        steamer.setPantryCar(steamerEntity.isPantryCar());
        steamer.setSeatList(parseListSeatEntityToListSeatModel(steamerEntity.getSeatEntities()));
        return steamer;
    }

    private List<Seat> parseListSeatEntityToListSeatModel(List<SeatEntity> seatEntities) {
        List<Seat> seatList = new ArrayList<>();
        for (SeatEntity seatEntity : seatEntities) {
            seatList.add(parseSeatEntityToSeatModel(seatEntity));
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
        trainSchedule.setFirstStation(trainScheduleEntity.getFirstStation().getStationName());
        trainSchedule.setLastStation(trainScheduleEntity.getLastStation().getStationName());
        trainSchedule.setJouneyName(trainScheduleEntity.getJouneyName());
        trainSchedule.setDepartureTime(trainScheduleEntity.getDepartureTime());
        trainSchedule.setArrivalTime(trainScheduleEntity.getArrivalTime());
        trainSchedule.setTrainID(trainScheduleEntity.getTrainEntity().getTrainID());
        return trainSchedule;
    }


}
