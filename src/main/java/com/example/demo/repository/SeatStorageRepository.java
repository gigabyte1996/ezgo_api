package com.example.demo.repository;

import com.example.demo.entity.SeatStorageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface SeatStorageRepository extends CrudRepository<SeatStorageEntity, Integer> {
    List<SeatStorageEntity> findSeatStorageEntitiesByUserEntity_UserID(Integer id);
    List<SeatStorageEntity> findAll();
    SeatStorageEntity findSeatStorageEntityBySeatIDAndTrainScheduleID(Integer seatID, Integer trainScheduleID);

}
