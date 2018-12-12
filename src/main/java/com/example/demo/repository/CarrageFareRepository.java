package com.example.demo.repository;


import com.example.demo.entity.CarrageFareEntity;
import com.example.demo.entity.SeatEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CarrageFareRepository extends CrudRepository<CarrageFareEntity, Integer> {
    List<CarrageFareEntity> findCarrageFareEntitiesByTrainScheduleEntity_TrainScheduleID(Integer trainScheduleID);
    CarrageFareEntity findCarrageFareEntityBySteamerEntity_SteamerIDAndTrainScheduleEntity_TrainScheduleID(Integer steamerID, Integer trainScheduleID);

}
