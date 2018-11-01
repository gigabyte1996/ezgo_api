package com.example.demo.service;

import com.example.demo.entity.StationEntity;
import com.example.demo.model.Station;
import com.example.demo.repository.StationRepository;
import com.example.demo.service.response.MessageResponse;
import com.example.demo.service.response.StationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StationServiceImpl implements StationService {

    @Autowired
    StationRepository stationRepository;
    @Override
    public StationResponse getListStation() {
        List<StationEntity> stationEntities = stationRepository.findAll();
        List<Station> stationList = new ArrayList<>();
        for (StationEntity stationEntity: stationEntities){
            stationList.add(parseStationEntityToStationModel(stationEntity));
        }
        MessageResponse messageResponse = new MessageResponse(0,"Success");
        StationResponse stationResponse = new StationResponse();
        stationResponse.setStationList(stationList);
        stationResponse.setMessageResponse(messageResponse);

        return stationResponse ;
    }

    private Station parseStationEntityToStationModel(StationEntity stationEntity) {
        Station station = new Station();
        station.setStationID(stationEntity.getStationID());
        station.setStationName(stationEntity.getStationName());
        return station;

    }
}
