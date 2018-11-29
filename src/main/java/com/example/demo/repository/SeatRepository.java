package com.example.demo.repository;

import com.example.demo.entity.SeatEntity;
import com.example.demo.entity.SteamerEntity;
import com.example.demo.model.Seat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface SeatRepository extends CrudRepository<SeatEntity, Integer> {
    List<SeatEntity> findSeatEntitiesBySteamerEntity_SteamerID(Integer id);
    SeatEntity findSeatEntitiesBySeatID(Integer id);

}
