package com.example.demo.service;

import com.example.demo.entity.SeatStatusEntity;
import com.example.demo.entity.TicketEntity;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.response.MessageResponse;
import com.example.demo.service.response.TicketDetailResponse;
import com.example.demo.service.response.TicketResponse;
import com.example.demo.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//import com.example.demo.entity.CustomerEntity;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TrainScheduleRepository trainScheduleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private SeatStatusRepository seatStatusRepository;

    @Override
    public TicketResponse createTicket(List<TicketRequest> ticketRequestList) {
        TicketResponse ticketResponse = new TicketResponse();
        List<Ticket> ticketList = new ArrayList<>();
        for (TicketRequest item : ticketRequestList) {
            Ticket ticket = new Ticket();
            ticket = createItemTicket(item);
            ticketList.add(ticket);
        }
        ticketResponse.setTickets(ticketList);
        if (ticketResponse.getTickets().size()!= 0){
            MessageResponse messageResponse =new MessageResponse(0, "Success");
            ticketResponse.setError(messageResponse);
        }
        MessageResponse messageResponse =new MessageResponse(0, "Success");
        return ticketResponse;
    }

    private Ticket createItemTicket(TicketRequest item) {
        TicketDetailResponse ticketDetailResponse = new TicketDetailResponse();
        List<TicketDetailResponse> ticketDetailResponses = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        SeatStorage seatStorage = item.getSeatStorage();
        Passenger passenger = item.getPassenger();
        Ticket ticket = new Ticket();
        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setFromStation(seatStorage.getFromStation());
        ticketEntity.setToStation(seatStorage.getToStation());
        ticketEntity.setTrainScheduleEntity(trainScheduleRepository.findTrainScheduleEntityByTrainScheduleID(seatStorage.getTrainScheduleID()));
        ticketEntity.setTrainName(seatStorage.getTrainName());
        ticketEntity.setSteamerNumber(seatStorage.getCarrageNumber());
        ticketEntity.setToStation(seatStorage.getToStation());
        ticketEntity.setFromStation(seatStorage.getFromStation());
        ticketEntity.setFare(seatStorage.getFare());
        ticketEntity.setSteamerType(seatStorage.getCarrageType());
        ticketEntity.setUserEntity(userRepository.findUserEntityByUserID(seatStorage.getUserID()));
        ticketEntity.setDepartureTime(seatStorage.getDepartureTime());
        ticketEntity.setPassengerName(passenger.getPassengerName());
        ticketEntity.setIdentificationNumber(passenger.getIdentificationNumber());
        ticketEntity.setTicketType(passenger.getTicketType());
        ticketEntity.setDateOfBirth(passenger.getDateOfBirth());
        ticketEntity.setSeatEntity(seatRepository.findSeatEntitiesBySeatID(seatStorage.getSeatID()));
        ticketEntity.setTicketCode(createTicketCode(ticketEntity));
        ticketRepository.save(ticketEntity);
        ticket = parseTicketEntityToTicketModel(ticketEntity);

        SeatStatusEntity seatStatusEntity = new SeatStatusEntity();
        seatStatusEntity = seatStatusRepository.findSeatStatusEntityByTrainScheduleEntity_TrainScheduleIDAndAndSeatEntity_SeatID(item.getSeatStorage().getTrainScheduleID(), item.getSeatStorage().getSeatID());
        seatStatusEntity.setSeatStatus(Constant.SeatStatus.RESERVED);
        return ticket;
    }

    private String createTicketCode(TicketEntity ticketEntity) {
        Integer userID = parseTicketEntityToTicketModel(ticketEntity).getUserID();
        Integer ticketID = parseTicketEntityToTicketModel(ticketEntity).getTicketID();
        String fromStation = parseTicketEntityToTicketModel(ticketEntity).getFromStation();
        String toStation = parseTicketEntityToTicketModel(ticketEntity).getToStation();
        String passengerName = parseTicketEntityToTicketModel(ticketEntity).getPassengerName();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String dateCreate = sdf.format(ticketEntity.getCreateDateTime());
        String ticketCode = userID + "-" + ticketID + "-" + fromStation + "-" + toStation + "-" + passengerName ;
        return ticketCode;
    }

    @Override
    public TicketResponse getTicketByUserID(UserRequest userRequest) {
        List<Ticket> ticketList = new ArrayList<>();
        ticketList = parseListTicketEntityToListTicketModel(ticketRepository.findTicketEntitiesByUserEntity_UserID(userRequest.getUserID()));
        MessageResponse messageResponse = new MessageResponse(0,"Success");
        TicketResponse ticketResponse = new TicketResponse(ticketList, messageResponse);
        return ticketResponse;
    }

    private List<Ticket> parseListTicketEntityToListTicketModel(List<TicketEntity> ticketEntityList){
        List<Ticket> ticketList = new ArrayList<>();
        for (TicketEntity item : ticketEntityList){
            Ticket ticket = new Ticket();
            ticket = parseTicketEntityToTicketModel(item);
            ticketList.add(ticket);
        }
        return ticketList;
    }


    private Ticket parseTicketEntityToTicketModel(TicketEntity ticketEntity) {
        Ticket ticket = new Ticket();
        ticket.setTicketID(ticketEntity.getId());
        ticket.setFromStation(ticketEntity.getFromStation());
        ticket.setToStation(ticketEntity.getToStation());
        ticket.setTrainScheduleID(ticketEntity.getTrainScheduleEntity().getTrainScheduleID());
        ticket.setTrainScheduleName(ticketEntity.getTrainScheduleEntity().getJouneyName());
        ticket.setTrainName(ticketEntity.getTrainName());
        ticket.setCarrageNumber(ticketEntity.getSteamerNumber());
        ticket.setCarrageType(ticketEntity.getSteamerType());
        ticket.setSeatNumber(ticketEntity.getSeatEntity().getSeatNumber());
        ticket.setSeatLocation(0);
        ticket.setUserID(ticketEntity.getUserEntity().getUserID());
        ticket.setFare(ticketEntity.getFare());
        ticket.setPassengerName(ticketEntity.getPassengerName());
        ticket.setIdentificationNumber(ticketEntity.getIdentificationNumber());
        ticket.setDateOfBirth(ticketEntity.getDateOfBirth());
        ticket.setTicketCode(ticketEntity.getTicketCode());
        ticket.setTrainScheduleCode(ticketEntity.getTrainScheduleEntity().getTrainScheduleCode());
        ticket.setDepartureTime(ticketEntity.getDepartureTime());
        ticket.setTicketStatus(0);

//        LocalDateTime dateTime = ticketEntity.getCreateDateTime();
//        ticket.setCreateDate(dateTime);
        return ticket;
    }

}
