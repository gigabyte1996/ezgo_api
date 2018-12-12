package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "FareScheduleEntity")
public class FareScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FareScheduleID")
    private Integer fareScheduleID;

    @ManyToOne
    @JoinColumn(name = "FromStationID", nullable = true)
    public StationEntity fromStation;

    @ManyToOne
    @JoinColumn(name = "ToStationID", nullable = true)
    public StationEntity toStation;

    @Basic
    @Column(name = "ScheduleTypeCode")
    private String ScheduleTypeCode;

    @Basic
    @Column(name = "SingleOrReturn")
    private boolean singleOrReturn;

    @Basic
    @Column(name = "SingleFare")
    private Integer singleFare;

    @Basic
    @Column(name = "returnFare")
    private Integer returnFare;

//    @OneToMany(mappedBy = "fareScheduleEntity", cascade = CascadeType.ALL)
//    private List<TicketEntity> ticketEntities;

    @ManyToOne
    @JoinColumn(name = "TrainScheduleID", nullable = false)
    private TrainScheduleEntity trainScheduleEntity;

    @ManyToOne
    @JoinColumn(name = "scheduleTypeID")
    private ScheduleTypeEntity scheduleTypeEntity;

    public StationEntity getFromStation() {
        return fromStation;
    }

    public void setFromStation(StationEntity fromStation) {
        this.fromStation = fromStation;
    }

    public StationEntity getToStation() {
        return toStation;
    }

    public void setToStation(StationEntity toStation) {
        this.toStation = toStation;
    }

    public ScheduleTypeEntity getScheduleTypeEntity() {
        return scheduleTypeEntity;
    }

    public void setScheduleTypeEntity(ScheduleTypeEntity scheduleTypeEntity) {
        this.scheduleTypeEntity = scheduleTypeEntity;
    }

    public Integer getFareScheduleID() {
        return fareScheduleID;
    }

    public void setFareScheduleID(Integer fareScheduleID) {
        this.fareScheduleID = fareScheduleID;
    }

    public String getScheduleTypeCode() {
        return ScheduleTypeCode;
    }

    public void setScheduleTypeCode(String scheduleTypeCode) {
        ScheduleTypeCode = scheduleTypeCode;
    }

    public boolean isSingleOrReturn() {
        return singleOrReturn;
    }

    public void setSingleOrReturn(boolean singleOrReturn) {
        this.singleOrReturn = singleOrReturn;
    }

    public int getSingleFare() {
        return singleFare;
    }

    public void setSingleFare(int singleFare) {
        this.singleFare = singleFare;
    }

    public int getReturnFare() {
        return returnFare;
    }

    public void setReturnFare(int returnFare) {
        this.returnFare = returnFare;
    }


    public TrainScheduleEntity getTrainScheduleEntity() {
        return trainScheduleEntity;
    }

    public void setTrainScheduleEntity(TrainScheduleEntity trainScheduleEntity) {
        this.trainScheduleEntity = trainScheduleEntity;
    }
}
