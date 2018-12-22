package com.example.demo.service;

import com.example.demo.entity.SeatStatusEntity;
import com.example.demo.entity.StationPerJourneyEntity;
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
import java.util.ArrayList;
import java.util.List;


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

    @Autowired
    private StationPerJouneyRepository stationPerJouneyRepository;

    @Autowired
    private StationRepository stationRepository;

    @Override
    public TicketResponse createTicket(String username, List<TicketRequest> ticketRequestList) {
        TicketResponse ticketResponse = new TicketResponse();
        List<Ticket> ticketList = new ArrayList<>();
        for (TicketRequest item : ticketRequestList) {
            Ticket ticket = new Ticket();
            ticket = createItemTicket(item);
            ticketList.add(ticket);
        }
        ticketResponse.setTickets(ticketList);
        if (ticketResponse.getTickets().size() != 0) {
            MessageResponse messageResponse = new MessageResponse(0, "Success");
            ticketResponse.setError(messageResponse);
        }
        return ticketResponse;
    }

    @Override
    public TicketDetailResponse getTicketDetailsByTicketID(String username, Integer ticketID) {
        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity = ticketRepository.findTicketEntityById(ticketID);
        MessageResponse messageResponse = null;
        if (ticketEntity != null) {
            messageResponse = new MessageResponse(0, "Success");
        }
        Ticket ticket = parseTicketEntityToTicketModel(ticketEntity);
        List<StationPerJourneyEntity> stationPerJourneyEntities = stationPerJouneyRepository.findStationPerJourneyEntitiesByTrainScheduleEntity_TrainScheduleIDOrderByDepartureTimeAsc(ticketEntity.getTrainScheduleEntity().getTrainScheduleID());
        List<StationPerJourney> stationPerJourneys = parseListStationPerJourneyEntityToListStationPerJourneyModel(stationPerJourneyEntities);
        Adminstraitor adminstraitor = new Adminstraitor();
        adminstraitor.setAdminstraitorName(ticketEntity.getTrainScheduleEntity().getAdministratorName());
        adminstraitor.setAdminPhoneNum(ticketEntity.getTrainScheduleEntity().getAdminPhoneNumb());
        TicketDetailResponse ticketDetailResponse = new TicketDetailResponse(ticket,  messageResponse, stationPerJourneys , adminstraitor);

        return ticketDetailResponse;
    }

    private List<StationPerJourney> parseListStationPerJourneyEntityToListStationPerJourneyModel(List<StationPerJourneyEntity> stationPerJourneyEntities) {
        List<StationPerJourney> stationPerJourneys = new ArrayList<>();
        for (StationPerJourneyEntity item : stationPerJourneyEntities){
            StationPerJourney stationPerJourney = new StationPerJourney();
            stationPerJourney = parseStationPerJourneyEntityToStationPerJourneyModel(item);
            stationPerJourneys.add(stationPerJourney);
        }
        return stationPerJourneys;
    }


    private Ticket createItemTicket(TicketRequest item) {
//        TicketDetailResponse ticketDetailResponse = new TicketDetailResponse();
//        List<TicketDetailResponse> ticketDetailResponses = new ArrayList<>();
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
        String ticketCode = userID + "-" + ticketID + "-" + fromStation + "-" + toStation + "-" + passengerName;
        return ticketCode;
    }

    @Override
    public TicketResponse getTicketByUserID(String username) {
        List<Ticket> ticketList = new ArrayList<>();
        ticketList = parseListTicketEntityToListTicketModel(ticketRepository.findTicketEntitiesByUserEntity_UserID(Integer.parseInt(username)));
        MessageResponse messageResponse = new MessageResponse(0, "Success");
        TicketResponse ticketResponse = new TicketResponse(ticketList, messageResponse);
        return ticketResponse;
    }

    private List<Ticket> parseListTicketEntityToListTicketModel(List<TicketEntity> ticketEntityList) {
        List<Ticket> ticketList = new ArrayList<>();
        for (TicketEntity item : ticketEntityList) {
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
        ticket.setTrainScheduleName(ticketEntity.getTrainScheduleEntity().getJouneyName());
        ticket.setTicketStatus(0);

//        LocalDateTime dateTime = ticketEntity.getCreateDateTime();
//        ticket.setCreateDate(dateTime);
        return ticket;
    }

    public StationPerJourney parseStationPerJourneyEntityToStationPerJourneyModel(StationPerJourneyEntity stationPerJourneyEntity){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        StationPerJourney stationPerJourney = new StationPerJourney();
        stationPerJourney.setStationPerJourneyID(stationPerJourneyEntity.getStationPerJourneyID());
        stationPerJourney.setTrainScheduleID(stationPerJourneyEntity.getTrainScheduleEntity().getTrainScheduleID());
        stationPerJourney.setStation(stationPerJourneyEntity.stationEntity.getStationName());
        stationPerJourney.setArrivalTime(sdf.format(stationPerJourneyEntity.getArrivalTime()));
        stationPerJourney.setDepartureTime(sdf.format(stationPerJourneyEntity.getDepartureTime()));
        return stationPerJourney;
    }

}
