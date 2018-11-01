package com.example.demo.repository;

import com.example.demo.entity.SteamerEntity;
import com.example.demo.entity.TrainEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface TrainRepository extends CrudRepository<TrainEntity , Integer> {
    TrainEntity findTrainEntityByTrainID(String id);
}
