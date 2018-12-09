package com.example.demo.service;

import com.example.demo.constant.HTTPCodeResponse;
//import com.example.demo.entity.CustomerEntity;
import com.example.demo.entity.SeatEntity;
import com.example.demo.entity.SeatStatusEntity;
import com.example.demo.entity.TicketEntity;
import com.example.demo.model.Customer;
import com.example.demo.model.Ticket;
import com.example.demo.model.TicketRequest;
import com.example.demo.model.User;
import com.example.demo.repository.*;
import com.example.demo.service.response.MessageResponse;
import com.example.demo.service.response.TicketDetailResponse;
import com.example.demo.service.response.TicketResponse;
import com.example.demo.utils.Constant;
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

//    @Autowired
//    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private SeatStatusRepository seatStatusRepository;

    @Override
    public TicketResponse createTicket(TicketRequest ticketRequest) {
        TicketResponse ticketResponse = new TicketResponse();
        List<Ticket> ticketList = new ArrayList<>();
        List<TicketDetailResponse> ticketDetailResponses = new ArrayList<>();
        TicketEntity ticketEntity = new TicketEntity();
        ticketList = ticketRequest.getTickets();
        SeatEntity seatEntity = new SeatEntity();


//        Customer customer = new Customer();
//        customer = ticketRequest.getCustomer();
//        CustomerEntity customerEntity = new CustomerEntity();
//        if (customer.getCustomerID() != null){
//            customerEntity = customerRepository.findCustomerEntityByCustomerID(customer.getCustomerID());
//        }else {
//            customerEntity.setCustomerName(customer.getCustomerName());
//            customerEntity.setIdentificationNumber(customer.getIdentificationNumber());
//            customerEntity.setPhoneNumber(customer.getPhoneNumber());
//            customerEntity.setUserEntity(userRepository.findUserEntitiesByUserID(customer.getUserID()));
//            customerRepository.save(customerEntity);
//        }
        for (Ticket itemTicket : ticketList){
            ticketEntity.setFromStation(itemTicket.getFromStation());
            ticketEntity.setToStation(itemTicket.getToStation());
            ticketEntity.setScheduleTypeCode(itemTicket.getScheduleTypeCode());
            ticketEntity.setTrainCode(itemTicket.getTrainCode());
            ticketEntity.setSteamerCode(itemTicket.getSteamerCode());
            ticketEntity.setSingOrReTurn(itemTicket.getSingleOrReturn());
            ticketEntity.setPassengerName(itemTicket.getPassengerName());
            ticketEntity.setFare(itemTicket.getFare());
            ticketEntity.setIdentificationNumber(itemTicket.getIdentificationNumber());
            ticketEntity.setAge(itemTicket.getAge());
            ticketEntity.setSeatEntity(seatRepository.findSeatEntitiesBySeatID(itemTicket.getSeatCode()));
//            ticketEntity.setCustomerEntity(customerRepository.findCustomerEntityByCustomerID(customerEntity.getCustomerID()));
            ticketRepository.save(ticketEntity);
            createTicketCode(ticketEntity);
            TicketDetailResponse ticketDetailResponse = new TicketDetailResponse();
            ticketDetailResponse.setTicket(parseTicketEntityToTicketModel(ticketEntity));
            ticketDetailResponse.setTicketCode(createTicketCode(ticketEntity));
            ticketDetailResponses.add(ticketDetailResponse);
            SeatStatusEntity seatStatusEntity = new SeatStatusEntity();
            seatStatusEntity = seatStatusRepository.findSeatStatusEntityByTrainScheduleEntity_TrainScheduleIDAndAndSeatEntity_SeatID(itemTicket.getTrainScheduleID(),itemTicket.getSeatCode());
            seatStatusEntity.setSeatStatus(Constant.SeatStatus.RESERVED);
        }

        List<SeatEntity> seatEntities = new ArrayList<>();

        ticketResponse.setTicketDetailResponses(ticketDetailResponses);
        ticketResponse.setError(new MessageResponse(HTTPCodeResponse.SUCCESS, "Success"));
        return ticketResponse;
    }
//
//    private CustomerEntity parseCustomerModelToCustomerEntity(Customer customer) {
//        CustomerEntity customerEntity = new CustomerEntity();
//        customerEntity.setCustomerID(customer.getCustomerID());
//        customerEntity.setCustomerName(customer.getCustomerName());
//        customerEntity.setUserEntity(userRepository.findUserEntitiesByUserID(customer.getUserID()));
//        customerEntity.setEmail(customer.getEmail());
//        customerEntity.setPhoneNumber(customer.getPhoneNumber());
//        customerEntity.setIdentificationNumber(customer.getIdentificationNumber());
//        return customerEntity;
//    }

    private String createTicketCode(TicketEntity ticketEntity) {
        Integer userID = parseTicketEntityToTicketModel(ticketEntity).getUserID();
        Integer ticketID = parseTicketEntityToTicketModel(ticketEntity).getTicketID();
        String fromStation = parseTicketEntityToTicketModel(ticketEntity).getFromStation();
        String toStation = parseTicketEntityToTicketModel(ticketEntity).getToStation();
        String passengerName = parseTicketEntityToTicketModel(ticketEntity).getPassengerName();
        String ticketCode = userID + "-" + ticketID + "-" + fromStation + "-" + toStation + "-" + passengerName;
        return ticketCode;
    }

    private Ticket parseTicketEntityToTicketModel(TicketEntity ticketEntity){
        Ticket ticket = new Ticket();
        ticket.setTicketID(ticketEntity.getId());
        ticket.setFareScheduleID(ticketEntity.getFareScheduleEntity().getFareScheduleID());
        ticket.setFromStation(ticketEntity.getFromStation());
        ticket.setToStation(ticketEntity.getToStation());
        ticket.setScheduleTypeCode(ticketEntity.getScheduleTypeCode());
        ticket.setTrainCode(ticketEntity.getTrainCode());
        ticket.setSteamerCode(ticketEntity.getSteamerCode());
        ticket.setSingleOrReturn(ticketEntity.getSingOrReTurn());
        ticket.setFare(ticketEntity.getFare());
        ticket.setPassengerName(ticketEntity.getPassengerName());
        ticket.setIdentificationNumber(ticketEntity.getIdentificationNumber());
        ticket.setAge(ticketEntity.getAge());
        ticket.setSeatCode(ticketEntity.getSeatEntity().getSeatID());
        return ticket;
    }

}
