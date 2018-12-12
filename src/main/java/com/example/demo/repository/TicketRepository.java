package com.example.demo.repository;

import com.example.demo.entity.FareScheduleEntity;
import com.example.demo.entity.TicketEntity;
import com.example.demo.entity.TrainScheduleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TicketRepository extends CrudRepository<TicketEntity, Integer> {
    List<TicketEntity> findTicketEntitiesByUserEntity_UserID(Integer userID);
}
