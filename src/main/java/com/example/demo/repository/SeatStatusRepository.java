package com.example.demo.repository;


import com.example.demo.entity.SeatEntity;
import com.example.demo.entity.SeatStatusEntity;
import com.example.demo.entity.TrainScheduleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface SeatStatusRepository extends CrudRepository<SeatStatusEntity, Integer> {
    SeatStatusEntity findSeatStatusEntityByTrainScheduleEntity_TrainScheduleIDAndAndSeatEntity_SeatID(Integer trainScheduleID, Integer seatID);

}
