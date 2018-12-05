package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "seats")
public class SeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SeatID")
    private Integer seatID;

    @Basic
    @Column(name = "SeatNumber")
    private Integer seatNumber;

//    @Basic
//    @Column(name = "SeatStatus")
//    private Integer seatStatus;

//    @ManyToOne
//    @JoinColumn(name = "seatStatusID", nullable = true)
//    private SeatStatusEntity seatStatusEntity;

    @Basic
    @Column(name = "SeatType")
    private Integer seatType;

    @ManyToOne
    @JoinColumn(name = "steamerID", nullable = true)
    private SteamerEntity steamerEntity;

    @OneToMany(mappedBy = "seatEntity", cascade = CascadeType.ALL)
    List<TicketEntity> ticketEntities;

    @OneToMany(mappedBy = "seatEntity", cascade = CascadeType.ALL)
    List<SeatStatusEntity> seatStatusEntities;

    public SeatEntity() {
    }

    public Integer getSeatID() {
        return seatID;
    }

    public void setSeatID(Integer seatID) {
        this.seatID = seatID;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Integer getSeatType() {
        return seatType;
    }

    public void setSeatType(Integer seatType) {
        this.seatType = seatType;
    }

    public SteamerEntity getSteamerEntity() {
        return steamerEntity;
    }

    public void setSteamerEntity(SteamerEntity steamerEntity) {
        this.steamerEntity = steamerEntity;
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

    public SeatEntity(Integer seatNumber, Integer seatType, SteamerEntity steamerEntity, List<TicketEntity> ticketEntities, List<SeatStatusEntity> seatStatusEntities) {
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.steamerEntity = steamerEntity;
        this.ticketEntities = ticketEntities;
        this.seatStatusEntities = seatStatusEntities;
    }
}
