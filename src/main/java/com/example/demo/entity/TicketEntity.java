package com.example.demo.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "ticket")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TicketID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "trainScheduleID", nullable = false)
    private TrainScheduleEntity trainScheduleEntity;

    @Basic
    @Column(name = "fromStation")
    private String fromStation;

    @Basic
    @Column(name = "toStation")
    private String toStation;


    @Basic
    @Column(name = "ticketType")
    private String ticketType;

    @Basic
    @Column(name = "trainName")
    private String trainName;


    @Basic
    @Column(name = "steamerType")
    private Integer steamerType;

    @Basic
    @Column(name = "steamerNumber")
    private Integer steamerNumber;

    @Basic
    @Column(name = "seatLocation")
    private String seatLocation;


    @Basic
    @Column(name = "fare")
    private Integer fare;

    @Basic
    @Column(name = "departureTime")
    private Date departureTime;

    @Basic
    @Column(name = "PassengerName")
    private  String passengerName;


    @Basic
    @Column(name = "IdentificationNumber")
    private String identificationNumber;

    @Basic
    @Column(name = "dateOfBirth")
    private Date dateOfBirth;


    @Basic
    @Column(name = "TicketCode")
    private String ticketCode;

    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    public UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "seatID", nullable = false)
    public SeatEntity seatEntity;

//    @ManyToOne
//    @JoinColumn(name = "FareScheduleID", nullable = false)
//    private FareScheduleEntity fareScheduleEntity;
//
//    @Column
//    @CreationTimestamp
//    private LocalDateTime createDateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TrainScheduleEntity getTrainScheduleEntity() {
        return trainScheduleEntity;
    }

    public void setTrainScheduleEntity(TrainScheduleEntity trainScheduleEntity) {
        this.trainScheduleEntity = trainScheduleEntity;
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }



    public Integer getSteamerType() {
        return steamerType;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public Integer getFare() {
        return fare;
    }

    public void setFare(Integer fare) {
        this.fare = fare;
    }

    public void setSteamerType(Integer steamerType) {
        this.steamerType = steamerType;
    }

    public Integer getSteamerNumber() {
        return steamerNumber;
    }

    public void setSteamerNumber(Integer steamerNumber) {
        this.steamerNumber = steamerNumber;
    }

    public String getSeatLocation() {
        return seatLocation;
    }

    public void setSeatLocation(String seatLocation) {
        this.seatLocation = seatLocation;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

//    public LocalDateTime getCreateDateTime() {
//        return createDateTime;
//    }


    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }
// banj ddeer im toi sua cho
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public SeatEntity getSeatEntity() {
        return seatEntity;
    }

    public void setSeatEntity(SeatEntity seatEntity) {
        this.seatEntity = seatEntity;
    }

    public TicketEntity() {
    }

    public TicketEntity(TrainScheduleEntity trainScheduleEntity, String fromStation, String toStation, String ticketType, String trainName, Integer steamerType, Integer steamerNumber, String seatLocation, Integer fare, Date departureTime, String passengerName, String identificationNumber, Date dateOfBirth, String ticketCode, UserEntity userEntity, SeatEntity seatEntity) {
        this.trainScheduleEntity = trainScheduleEntity;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.ticketType = ticketType;
        this.trainName = trainName;
        this.steamerType = steamerType;
        this.steamerNumber = steamerNumber;
        this.seatLocation = seatLocation;
        this.fare = fare;
        this.departureTime = departureTime;
        this.passengerName = passengerName;
        this.identificationNumber = identificationNumber;
        this.dateOfBirth = dateOfBirth;
        this.ticketCode = ticketCode;
        this.userEntity = userEntity;
        this.seatEntity = seatEntity;
    }
}
