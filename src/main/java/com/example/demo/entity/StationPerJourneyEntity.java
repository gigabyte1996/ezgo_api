package com.example.demo.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "StationPerJourney")
public class StationPerJourneyEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stationPerJourneyID")
    private Integer stationPerJourneyID;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "stationID", referencedColumnName = "StationID")
    public StationEntity stationEntity;

    @ManyToOne
    @JoinColumn(name = "trainScheduleID", nullable = false)
    public TrainScheduleEntity trainScheduleEntity;

    @Basic
    @Column(name = "arrivalTime")
    private Date arrivalTime;

    @Basic
    @Column(name = "departureTime")
    private Date departureTime;

    public Integer getStationPerJourneyID() {
        return stationPerJourneyID;
    }

    public void setStationPerJourneyID(Integer stationPerJourneyID) {
        this.stationPerJourneyID = stationPerJourneyID;
    }

    public StationEntity getStationEntity() {
        return stationEntity;
    }

    public void setStationEntity(StationEntity stationEntity) {
        this.stationEntity = stationEntity;
    }

    public TrainScheduleEntity getTrainScheduleEntity() {
        return trainScheduleEntity;
    }

    public void setTrainScheduleEntity(TrainScheduleEntity trainScheduleEntity) {
        this.trainScheduleEntity = trainScheduleEntity;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public StationPerJourneyEntity(Integer stationPerJourneyID, StationEntity stationEntity, TrainScheduleEntity trainScheduleEntity, Date arrivalTime, Date departureTime) {
        this.stationPerJourneyID = stationPerJourneyID;
        this.stationEntity = stationEntity;
        this.trainScheduleEntity = trainScheduleEntity;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }
}
