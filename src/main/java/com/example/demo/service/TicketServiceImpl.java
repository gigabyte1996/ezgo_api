package com.example.demo.service;

import com.example.demo.constant.HTTPCodeResponse;
import com.example.demo.entity.CustomerEntity;
import com.example.demo.entity.TicketEntity;
import com.example.demo.model.Customer;
import com.example.demo.model.Ticket;
import com.example.demo.model.TicketRequest;
import com.example.demo.model.User;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.response.MessageResponse;
import com.example.demo.service.response.TicketDetailResponse;
import com.example.demo.service.response.TicketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public TicketResponse createTicket(TicketRequest ticketRequest) {
        TicketResponse ticketResponse = new TicketResponse();
        List<Ticket> ticketList = new ArrayList<>();
        List<TicketDetailResponse> ticketDetailResponses = new ArrayList<>();
        ticketList = ticketRequest.getTickets();
        CustomerEntity customerEntity = customerRepository.save(parseCustomerModelToCustomerEntity(ticketRequest.getCustomer()));
        for (Ticket itemTicket: ticketList){
            TicketEntity ticketEntity = parseTicketModelToTicketEntity(itemTicket);
            TicketEntity newTicket = ticketRepository.save(ticketEntity);
            TicketDetailResponse ticket = new TicketDetailResponse();
            ticket.setTicket(parseTicketEntityToTicketModel(ticketEntity));
            ticket.setTicketCode(createTicketCode(newTicket));
            ticketDetailResponses.add(ticket);
        }
        ticketResponse.setTicketDetailResponses(ticketDetailResponses);
        ticketResponse.setError(new MessageResponse(HTTPCodeResponse.SUCCESS, "Success"));
        return ticketResponse;
    }

    private CustomerEntity parseCustomerModelToCustomerEntity(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustomerID(customer.getCustomerID());
        customerEntity.setCustomerName(customer.getCustomerName());
        customerEntity.setUserEntity(userRepository.findUserEntitiesByUserID(customer.getUserID()));
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setPhoneNumber(customer.getPhoneNumber());
        customerEntity.setIdentificationNumber(customer.getIdentificationNumber());
        return customerEntity;
    }

    private String createTicketCode(TicketEntity ticketEntity) {
        String userID = parseTicketEntityToTicketModel(ticketEntity).getUserID();
        Integer ticketID = parseTicketEntityToTicketModel(ticketEntity).getTicketID();
        String fromStation = parseTicketEntityToTicketModel(ticketEntity).getFromStation();
        String toStation = parseTicketEntityToTicketModel(ticketEntity).getToStation();
        String passengerName = parseTicketEntityToTicketModel(ticketEntity).getPassengerName();
        String ticketCode = userID + "-" + ticketID + "-" + fromStation + "-" + toStation + "-" + passengerName;
        return ticketCode;
    }

    private TicketEntity parseTicketModelToTicketEntity(Ticket ticket) {
        TicketEntity ticketEntity = new TicketEntity();

//        ticketEntity.setId(ticket.getTicketID());
        ticketEntity.setFareScheduleEntity(ticketRepository.findTicketEntityById(ticket.getTicketID()));
        ticketEntity.setFromStation(ticket.getFromStation());
        ticketEntity.setToStation(ticket.getToStation());
        ticketEntity.setScheduleTypeCode(ticket.getScheduleTypeCode());
        ticketEntity.setTrainCode(ticket.getTrainCode());
        ticketEntity.setSeatCode(ticket.getSeatCode());
        ticketEntity.setSteamerCode(ticket.getSteamerCode());
        ticketEntity.setSingOrReTurn(ticket.getSingleOrReturn());
        ticketEntity.setFare(ticket.getFare());
        ticketEntity.setPassengerName(ticket.getPassengerName());
        ticketEntity.setIdentificationNumber(ticket.getIdentificationNumber());
        ticketEntity.setAge(ticket.getAge());
        return ticketEntity;
    }

    private Ticket parseTicketEntityToTicketModel(TicketEntity ticketEntity){
        Ticket ticket = new Ticket();
        ticket.setTicketID(ticketEntity.getId());
        ticket.setFareScheduleID(ticketEntity.getFareScheduleEntity().getFareScheduleID());
        ticket.setFromStation(ticketEntity.getFromStation());
        ticket.setToStation(ticketEntity.getToStation());
        ticket.setScheduleTypeCode(ticketEntity.getScheduleTypeCode());
        ticket.setTrainCode(ticketEntity.getTrainCode());
        ticket.setSeatCode(ticketEntity.getSeatCode());
        ticket.setSteamerCode(ticketEntity.getSteamerCode());
        ticket.setSingleOrReturn(ticketEntity.getSingOrReTurn());
        ticket.setFare(ticketEntity.getFare());
        ticket.setPassengerName(ticketEntity.getPassengerName());
        ticket.setIdentificationNumber(ticketEntity.getIdentificationNumber());
        ticket.setAge(ticketEntity.getAge());
        return ticket;
    }

}
