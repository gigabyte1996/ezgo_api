package com.example.demo.service;


import com.example.demo.entity.SteamerEntity;
import com.example.demo.entity.TrainEntity;
import com.example.demo.entity.TrainScheduleEntity;
import com.example.demo.model.*;
import com.example.demo.repository.SteamerRepository;
import com.example.demo.repository.TrainRepository;
import com.example.demo.repository.TrainScheduleRepository;
import com.example.demo.service.response.MessageResponse;
import com.example.demo.service.response.TrainDetail;
import com.example.demo.service.response.TrainScheduleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainScheduleRepository trainScheduleRepository;

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private SteamerRepository steamerRepository;

    @Override
    public TrainScheduleResponse searchTrain(TrainRequest requestTrain) {
        List<TrainScheduleEntity> trainScheduleEntities = trainScheduleRepository.findAll();
        List<TrainSchedule> trainScheduleList = new ArrayList<>();
        MessageResponse messageResponse = new MessageResponse(0,"Success");
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
        String departureTimeRequest = sdf.format(requestTrain.getDepartureTime());
        String arrivalTimeRequest = sdf.format(requestTrain.getArrivalTime());

        for (TrainScheduleEntity item : trainScheduleEntities ){
            String departureTime = sdf.format(item.getDepartureTime());
            String arrivalTime = sdf.format(item.getArrivalTime());

            if (item.getFirstStation().equals(requestTrain.getFromStation())
                    && item.getLastStation().equals(requestTrain.getToStation())
                    && departureTimeRequest.equals(departureTime)
                    && arrivalTimeRequest.equals(arrivalTime) ){
                trainScheduleList.add(parseTrainScheduleEntityToTrainSchdeduleModel(item));
            }
        }
        return new TrainScheduleResponse(trainScheduleList, messageResponse);
    }

    @Override
    public TrainDetail getTrainDiagrambyTrainId(String id) {
        TrainEntity trainEntity = trainRepository.findTrainEntityByTrainID(id);
        List<SteamerEntity> steamerEntities = steamerRepository.findSteamerEntitiesByTrainEntity_TrainID(id);
        List<Steamer> steamers = new ArrayList<>();
        Train train = parseTrainEntityToTrainModel(trainEntity);
        MessageResponse messageResponse = new MessageResponse(0,"Success");
        for (SteamerEntity steamerEntity : steamerEntities) {
            Steamer steamer = parseSteamerEntityToSteamerModel(steamerEntity);
            steamers.add(steamer);
        }
        TrainDetail trainDetail = new TrainDetail(train.getTrainID(), train.getTrainNumber(), train.getTrainType(), steamers,messageResponse  );
        return trainDetail;
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
        steamer.setPantryCar(steamerEntity.isPantryCar());

        return steamer;
    }


    private Train parseTrainEntityToTrainModel(TrainEntity trainEntity) {
        Train train = new Train();
        train.setTrainID(trainEntity.getTrainID());
        train.setTrainNumber(trainEntity.getTrainNumber());
        train.setTrainType(trainEntity.getTrainType());
        return  train;
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
