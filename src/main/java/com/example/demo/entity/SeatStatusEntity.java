package com.example.demo.entity;


import com.example.demo.model.TrainSchedule;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "seatStatus")
public class SeatStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SeatStatusID")
    private Integer SeatStatusID;

//    @OneToMany(mappedBy = "seatStatusEntity", cascade = CascadeType.ALL)
//    List<SeatEntity> seatEntities;
//
//    @OneToMany(mappedBy = "seatStatusEntity", cascade = CascadeType.ALL)
//    List<TrainScheduleEntity> trainScheduleEntities;

    @ManyToOne
    @JoinColumn(name = "seatID", nullable = true)
    private SeatEntity seatEntity;

    @ManyToOne
    @JoinColumn(name = "trainScheduleID", nullable = true)
    private TrainScheduleEntity trainScheduleEntity;

    @Basic
    @Column(name = "seatStatus")
    private Integer seatStatus;

    public SeatStatusEntity() {
    }

    public Integer getSeatStatusID() {
        return SeatStatusID;
    }

    public void setSeatStatusID(Integer seatStatusID) {
        SeatStatusID = seatStatusID;
    }

    public SeatEntity getSeatEntity() {
        return seatEntity;
    }

    public void setSeatEntity(SeatEntity seatEntity) {
        this.seatEntity = seatEntity;
    }

    public TrainScheduleEntity getTrainScheduleEntity() {
        return trainScheduleEntity;
    }

    public void setTrainScheduleEntity(TrainScheduleEntity trainScheduleEntity) {
        this.trainScheduleEntity = trainScheduleEntity;
    }

    public Integer getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(Integer seatStatus) {
        this.seatStatus = seatStatus;
    }

    public SeatStatusEntity(SeatEntity seatEntity, TrainScheduleEntity trainScheduleEntity, Integer seatStatus) {
        this.seatEntity = seatEntity;
        this.trainScheduleEntity = trainScheduleEntity;
        this.seatStatus = seatStatus;
    }
}
