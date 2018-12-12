package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "carrageFare")
public class CarrageFareEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carrageFareID")
    private Integer CarrageFareID;

//    @OneToMany(mappedBy = "seatStatusEntity", cascade = CascadeType.ALL)
//    List<SeatEntity> seatEntities;
//
//    @OneToMany(mappedBy = "seatStatusEntity", cascade = CascadeType.ALL)
//    List<TrainScheduleEntity> trainScheduleEntities;

    @ManyToOne
    @JoinColumn(name = "carrageID", nullable = true)
    private SteamerEntity steamerEntity;

    @ManyToOne
    @JoinColumn(name = "trainScheduleID", nullable = true)
    private TrainScheduleEntity trainScheduleEntity;

    @Basic
    @Column(name = "carrageFare")
    private Integer carrageFare;

    public Integer getCarrageFareID() {
        return CarrageFareID;
    }

    public void setCarrageFareID(Integer carrageFareID) {
        CarrageFareID = carrageFareID;
    }

    public SteamerEntity getSteamerEntity() {
        return steamerEntity;
    }

    public void setSteamerEntity(SteamerEntity steamerEntity) {
        this.steamerEntity = steamerEntity;
    }

    public TrainScheduleEntity getTrainScheduleEntity() {
        return trainScheduleEntity;
    }

    public void setTrainScheduleEntity(TrainScheduleEntity trainScheduleEntity) {
        this.trainScheduleEntity = trainScheduleEntity;
    }

    public Integer getCarrageFare() {
        return carrageFare;
    }

    public void setCarrageFare(Integer carrageFare) {
        this.carrageFare = carrageFare;
    }

    public CarrageFareEntity(SteamerEntity steamerEntity, TrainScheduleEntity trainScheduleEntity, Integer carrageFare) {
        this.steamerEntity = steamerEntity;
        this.trainScheduleEntity = trainScheduleEntity;
        this.carrageFare = carrageFare;
    }
}
