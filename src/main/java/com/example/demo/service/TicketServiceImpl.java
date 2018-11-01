package com.example.demo.service;

import com.example.demo.constant.HTTPCodeResponse;
import com.example.demo.entity.TicketEntity;
import com.example.demo.model.Ticket;
import com.example.demo.repository.TicketRepository;
import com.example.demo.service.response.MessageResponse;
import com.example.demo.service.response.TicketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public TicketResponse createTicket(Ticket ticket) {
        TicketResponse ticketResponse = new TicketResponse();
        TicketEntity ticketEntity = parseTicketModelToTicketEntity(ticket);
        TicketEntity newTicket = ticketRepository.save(ticketEntity);
        ticketResponse.setError(new MessageResponse(HTTPCodeResponse.SUCCESS, "Success"));
        ticketResponse.setTicketID(parseTicketEntityToTicketModel(newTicket).getTicketID());
        ticketResponse.setTicketCode(createTicketCode(ticket.getTicketID()));
        return ticketResponse;
    }

    private String createTicketCode(String ticketID) {
        return "aaaaaaaaaaaaaaa";
    }

    private TicketEntity parseTicketModelToTicketEntity(Ticket ticket) {
        TicketEntity ticketEntity = new TicketEntity();

        ticketEntity.setId(ticket.getTicketID());
        ticketEntity.setFareScheduleEntity(ticketRepository.findTicketEntityById(ticket.getTicketID()));
        ticketEntity.setFromStation(ticket.getFromStationID());
        ticketEntity.setToStation(ticket.getToStationID());
        ticketEntity.setScheduleTypeCode(ticket.getScheduleTypeCode());
        ticketEntity.setTrainCode(ticket.getTrainCode());
        ticketEntity.setSeatCode(ticket.getSeatCode());
        ticketEntity.setSteamerCode(ticket.getSteamerCode());
        ticketEntity.setSingOrReTurn(ticket.getSingleOrReturn());
        ticketEntity.setFare(ticket.getFare());
        ticketEntity.setPassengerName(ticket.getPassengerName());
        ticketEntity.setEmail(ticket.getEmail());
        ticketEntity.setPhoneNumber(ticket.getPhoneNumber());
        ticketEntity.setIdentificationNumber(ticket.getIdentificationNumber());
        ticketEntity.setAge(ticket.getAge());
        return ticketEntity;
    }

    private Ticket parseTicketEntityToTicketModel(TicketEntity ticketEntity){
        Ticket ticket = new Ticket();
        ticket.setTicketID(ticketEntity.getId());
        ticket.setFareScheduleID(ticketEntity.getFareScheduleEntity().getFareScheduleID());
        ticket.setFromStationID(ticketEntity.getFromStation());
        ticket.setToStationID(ticketEntity.getToStation());
        ticket.setScheduleTypeCode(ticketEntity.getScheduleTypeCode());
        ticket.setTrainCode(ticketEntity.getTrainCode());
        ticket.setSeatCode(ticketEntity.getSeatCode());
        ticket.setSteamerCode(ticketEntity.getSteamerCode());
        ticket.setSingleOrReturn(ticketEntity.getSingOrReTurn());
        ticket.setFare(ticketEntity.getFare());
        ticket.setPassengerName(ticketEntity.getPassengerName());
        ticket.setEmail(ticketEntity.getEmail());
        ticket.setPhoneNumber(ticketEntity.getPhoneNumber());
        ticket.setIdentificationNumber(ticketEntity.getIdentificationNumber());
        ticket.setAge(ticketEntity.getAge());
        return ticket;
    }
}
