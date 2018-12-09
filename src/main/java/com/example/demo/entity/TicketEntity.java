package com.example.demo.entity;

import javax.persistence.*;

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
    @Column(name = "scheduleTypeCode")
    private Integer scheduleTypeCode;

    @Basic
    @Column(name = "trainCode")
    private Integer trainCode;


    @Basic
    @Column(name = "steamerCode")
    private Integer steamerCode;

    @Basic
    @Column(name = "singleOrReturn")
    private Integer singOrReTurn;

    @Basic
    @Column(name = "fare")
    private Long fare;

    @Basic
    @Column(name = "PassengerName")
    private  String passengerName;

    @Basic
    @Column(name = "IdentificationNumber")
    private String identificationNumber;

    @Basic
    @Column(name = "Age")
    private Integer age;

    @Basic
    @Column(name = "TicketCode")
    private String ticketCode;

    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    public UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "seatID", nullable = false)
    public SeatEntity seatEntity;

    @ManyToOne
    @JoinColumn(name = "FareScheduleID", nullable = false)
    private FareScheduleEntity fareScheduleEntity;

//    @ManyToOne
//    @JoinColumn(name = "customerID", nullable = false)
//    public CustomerEntity customerEntity;

    public TicketEntity() {
    }

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

    public Integer getScheduleTypeCode() {
        return scheduleTypeCode;
    }

    public void setScheduleTypeCode(Integer scheduleTypeCode) {
        this.scheduleTypeCode = scheduleTypeCode;
    }

    public Integer getTrainCode() {
        return trainCode;
    }

    public void setTrainCode(Integer trainCode) {
        this.trainCode = trainCode;
    }

    public Integer getSteamerCode() {
        return steamerCode;
    }

    public void setSteamerCode(Integer steamerCode) {
        this.steamerCode = steamerCode;
    }

    public Integer getSingOrReTurn() {
        return singOrReTurn;
    }

    public void setSingOrReTurn(Integer singOrReTurn) {
        this.singOrReTurn = singOrReTurn;
    }

    public Long getFare() {
        return fare;
    }

    public void setFare(Long fare) {
        this.fare = fare;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

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

    public FareScheduleEntity getFareScheduleEntity() {
        return fareScheduleEntity;
    }

    public void setFareScheduleEntity(FareScheduleEntity fareScheduleEntity) {
        this.fareScheduleEntity = fareScheduleEntity;
    }

//    public CustomerEntity getCustomerEntity() {
//        return customerEntity;
//    }
//
//    public void setCustomerEntity(CustomerEntity customerEntity) {
//        this.customerEntity = customerEntity;
//    }


    public TicketEntity(TrainScheduleEntity trainScheduleEntity, String fromStation, String toStation, Integer scheduleTypeCode, Integer trainCode, Integer steamerCode, Integer singOrReTurn, Long fare, String passengerName, String identificationNumber, Integer age, String ticketCode, UserEntity userEntity, SeatEntity seatEntity, FareScheduleEntity fareScheduleEntity) {
        this.trainScheduleEntity = trainScheduleEntity;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.scheduleTypeCode = scheduleTypeCode;
        this.trainCode = trainCode;
        this.steamerCode = steamerCode;
        this.singOrReTurn = singOrReTurn;
        this.fare = fare;
        this.passengerName = passengerName;
        this.identificationNumber = identificationNumber;
        this.age = age;
        this.ticketCode = ticketCode;
        this.userEntity = userEntity;
        this.seatEntity = seatEntity;
        this.fareScheduleEntity = fareScheduleEntity;
    }
}
