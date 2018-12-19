package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class TrainSchedule {
    private Integer trainScheduleID;
    private String jouneyName;
    private String trainName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss", timezone="Asia/Ho_Chi_Minh")
    private Date departureTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss", timezone="Asia/Ho_Chi_Minh")
    private Date arrivalTime;

    private String firstStation;
    private String lastStation;
    private Integer trainID;
    private String trainScheduleCode;
    private List<StationPerJourney> stationPerJourneys;
    private String AdministratorName;
    private String AdminPhoneNumb;

    public String getAdministratorName() {
        return AdministratorName;
    }

    public void setAdministratorName(String administratorName) {
        AdministratorName = administratorName;
    }

    public String getAdminPhoneNumb() {
        return AdminPhoneNumb;
    }

    public void setAdminPhoneNumb(String adminPhoneNumb) {
        AdminPhoneNumb = adminPhoneNumb;
    }

    public Integer getTrainScheduleID() {
        return trainScheduleID;
    }

    public void setTrainScheduleID(Integer trainScheduleID) {
        this.trainScheduleID = trainScheduleID;
    }

    public String getJouneyName() {
        return jouneyName;
    }

    public void setJouneyName(String jouneyName) {
        this.jouneyName = jouneyName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getFirstStation() {
        return firstStation;
    }

    public void setFirstStation(String firstStation) {
        this.firstStation = firstStation;
    }

    public String getLastStation() {
        return lastStation;
    }

    public void setLastStation(String lastStation) {
        this.lastStation = lastStation;
    }

    public Integer getTrainID() {
        return trainID;
    }

    public void setTrainID(Integer trainID) {
        this.trainID = trainID;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainScheduleCode() {
        return trainScheduleCode;
    }

    public void setTrainScheduleCode(String trainScheduleCode) {
        this.trainScheduleCode = trainScheduleCode;
    }

    public List<StationPerJourney> getStationPerJourneys() {
        return stationPerJourneys;
    }

    public void setStationPerJourneys(List<StationPerJourney> stationPerJourneys) {
        this.stationPerJourneys = stationPerJourneys;
    }
}
