package com.example.demo.model;

public class StationPerJourney {
    private Integer stationPerJourneyID;
    private String station;
    private Integer trainScheduleID;
    private String arrivalTime;
    private String departureTime;

    public StationPerJourney(Integer stationPerJourneyID, String station, Integer trainScheduleID, String arrivalTime, String departureTime) {
        this.stationPerJourneyID = stationPerJourneyID;
        this.station = station;
        this.trainScheduleID = trainScheduleID;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public StationPerJourney() {
    }

    public Integer getStationPerJourneyID() {
        return stationPerJourneyID;
    }

    public void setStationPerJourneyID(Integer stationPerJourneyID) {
        this.stationPerJourneyID = stationPerJourneyID;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public Integer getTrainScheduleID() {
        return trainScheduleID;
    }

    public void setTrainScheduleID(Integer trainScheduleID) {
        this.trainScheduleID = trainScheduleID;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
}
