package com.example.demo.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TrainSchedule")
public class TrainScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TrainScheduleID")
    private Integer trainScheduleID;

    @Basic
    @Column(name = "ScheduleTypeCode")
    private int scheduleTyprCode;

    @Basic
    @Column(name = "JouneyName")
    private String jouneyName;

    @Basic
    @Column(name = "DepartureTime")
    private Date departureTime;

    @Basic
    @Column(name = "ArrivalTime")
    private Date arrivalTime;

    @Basic
    @Column(name = "AdministratorName")
    private String AdministratorName;

    @Basic
    @Column(name = "AdminPhoneNumb")
    private String AdminPhoneNumb;

    @Basic
    @Column(name = "TrainScheduleCode")
    private String trainScheduleCode;

    @ManyToOne
    @JoinColumn(name = "FirstStationID", nullable = true)
    public StationEntity firstStation;

    @ManyToOne
    @JoinColumn(name = "LastStationID", nullable = true)
    public StationEntity lastStation;

    @ManyToOne
    @JoinColumn(name = "TrainID", nullable = true)
    private TrainEntity trainEntity;

    @OneToMany(mappedBy = "trainScheduleEntity", cascade = CascadeType.ALL)
    List<TicketEntity> ticketEntities;

    @OneToMany(mappedBy = "trainScheduleEntity", cascade = CascadeType.ALL)
    List<SeatStatusEntity> seatStatusEntities;

//    @OneToMany(mappedBy = "trainScheduleEntity", cascade = CascadeType.ALL)
//    List<FareScheduleEntity> fareScheduleEntities;

    @OneToMany(mappedBy = "trainScheduleEntity", cascade = CascadeType.ALL)
    List<StationPerJourneyEntity> stationPerJourneyEntities;



    public TrainScheduleEntity() {
    }

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

    public int getScheduleTyprCode() {
        return scheduleTyprCode;
    }

    public void setScheduleTyprCode(int scheduleTyprCode) {
        this.scheduleTyprCode = scheduleTyprCode;
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

    public StationEntity getFirstStation() {
        return firstStation;
    }

    public void setFirstStation(StationEntity firstStation) {
        this.firstStation = firstStation;
    }

    public StationEntity getLastStation() {
        return lastStation;
    }

    public void setLastStation(StationEntity lastStation) {
        this.lastStation = lastStation;
    }

    public TrainEntity getTrainEntity() {
        return trainEntity;
    }

    public void setTrainEntity(TrainEntity trainEntity) {
        this.trainEntity = trainEntity;
    }

    public List<TicketEntity> getTicketEntities() {
        return ticketEntities;
    }

    public void setTicketEntities(List<TicketEntity> ticketEntities) {
        this.ticketEntities = ticketEntities;
    }

    public List<SeatStatusEntity> getSeatStatusEntities() {
        return seatStatusEntities;
    }

    public void setSeatStatusEntities(List<SeatStatusEntity> seatStatusEntities) {
        this.seatStatusEntities = seatStatusEntities;
    }

//    public List<FareScheduleEntity> getFareScheduleEntities() {
//        return fareScheduleEntities;
//    }
//
//    public void setFareScheduleEntities(List<FareScheduleEntity> fareScheduleEntities) {
//        this.fareScheduleEntities = fareScheduleEntities;
//    }

    public List<StationPerJourneyEntity> getStationPerJourneyEntities() {
        return stationPerJourneyEntities;
    }

    public void setStationPerJourneyEntities(List<StationPerJourneyEntity> stationPerJourneyEntities) {
        this.stationPerJourneyEntities = stationPerJourneyEntities;
    }

    public String getTrainScheduleCode() {
        return trainScheduleCode;
    }

    public void setTrainScheduleCode(String trainScheduleCode) {
        this.trainScheduleCode = trainScheduleCode;
    }


}
