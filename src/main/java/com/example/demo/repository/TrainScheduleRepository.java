package com.example.demo.repository;


import com.example.demo.entity.TrainScheduleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TrainScheduleRepository extends CrudRepository<TrainScheduleEntity, Integer> {
    List<TrainScheduleEntity> findAll();

}
