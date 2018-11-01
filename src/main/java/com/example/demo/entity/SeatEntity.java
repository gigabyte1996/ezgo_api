package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "seats")
public class SeatEntity {
    @Id
    @Column(name = "SeatID")
    private String seatID;

    @Basic
    @Column(name = "SeatNumber")
    private int seatNumber;

    @Basic
    @Column(name = "SeatStatus")
    private int seatStatus;

    @Basic
    @Column(name = "SeatType")
    private int seatType;

    @ManyToOne
    @JoinColumn(name = "steamerID", nullable = true)
    private SteamerEntity steamerEntity;

    @OneToMany(mappedBy = "seatEntity", cascade = CascadeType.ALL)
    List<TicketEntity> ticketEntities;

    public String getSeatID() {
        return seatID;
    }

    public void setSeatID(String seatID) {
        this.seatID = seatID;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(int seatStatus) {
        this.seatStatus = seatStatus;
    }

    public int getSeatType() {
        return seatType;
    }

    public void setSeatType(int seatType) {
        this.seatType = seatType;
    }
}
