package com.example.demo.repository;

import com.example.demo.entity.FareScheduleEntity;
import com.example.demo.entity.TicketEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TicketRepository extends CrudRepository<TicketEntity, Integer> {
    FareScheduleEntity findTicketEntityById(String id);
}
