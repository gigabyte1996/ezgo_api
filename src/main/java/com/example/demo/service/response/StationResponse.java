package com.example.demo.service.response;

import com.example.demo.model.Station;

import java.util.List;

public class StationResponse {
    List<Station> stationList;
    MessageResponse messageResponse;

    public StationResponse() {
        this.stationList = stationList;
        this.messageResponse = messageResponse;
    }

    public List<Station> getStationList() {
        return stationList;
    }

    public void setStationList(List<Station> stationList) {
        this.stationList = stationList;
    }

    public MessageResponse getMessageResponse() {
        return messageResponse;
    }

    public void setMessageResponse(MessageResponse messageResponse) {
        this.messageResponse = messageResponse;
    }
}
