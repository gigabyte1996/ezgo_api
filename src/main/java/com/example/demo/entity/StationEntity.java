package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Station")
public class StationEntity {

    @Id
    @Column(name = "StationID")
    private int stationID;

    @Basic
    @Column(name = "StationName")
    private String stationName;

    @OneToMany(mappedBy = "firstStation", cascade = CascadeType.ALL)
    private List<TrainScheduleEntity> trainScheduleEntities1;

    @OneToMany(mappedBy = "lastStation", cascade = CascadeType.ALL)
    private List<TrainScheduleEntity> trainScheduleEntities2;

    @OneToMany(mappedBy = "fromStation", cascade = CascadeType.ALL)
    private List<FareScheduleEntity> fareScheduleEntities1;

    @OneToMany(mappedBy = "toStation", cascade = CascadeType.ALL)
    private List<FareScheduleEntity> fareScheduleEntities2;

    @OneToMany(mappedBy = "stationEntity", cascade = CascadeType.ALL)
    private List<StationPerJourneyEntity> stationPerJourneyEntities;

    public List<StationPerJourneyEntity> getStationPerJourneyEntities() {
        return stationPerJourneyEntities;
    }

    public void setStationPerJourneyEntities(List<StationPerJourneyEntity> stationPerJourneyEntities) {
        this.stationPerJourneyEntities = stationPerJourneyEntities;
    }

    public int getStationID() {
        return stationID;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public List<TrainScheduleEntity> getTrainScheduleEntities1() {
        return trainScheduleEntities1;
    }

    public void setTrainScheduleEntities1(List<TrainScheduleEntity> trainScheduleEntities1) {
        this.trainScheduleEntities1 = trainScheduleEntities1;
    }

    public List<TrainScheduleEntity> getTrainScheduleEntities2() {
        return trainScheduleEntities2;
    }

    public void setTrainScheduleEntities2(List<TrainScheduleEntity> trainScheduleEntities2) {
        this.trainScheduleEntities2 = trainScheduleEntities2;
    }

    public List<FareScheduleEntity> getFareScheduleEntities1() {
        return fareScheduleEntities1;
    }

    public void setFareScheduleEntities1(List<FareScheduleEntity> fareScheduleEntities1) {
        this.fareScheduleEntities1 = fareScheduleEntities1;
    }

    public List<FareScheduleEntity> getFareScheduleEntities2() {
        return fareScheduleEntities2;
    }

    public void setFareScheduleEntities2(List<FareScheduleEntity> fareScheduleEntities2) {
        this.fareScheduleEntities2 = fareScheduleEntities2;
    }
}
