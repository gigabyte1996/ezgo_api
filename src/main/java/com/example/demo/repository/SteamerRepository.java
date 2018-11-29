package com.example.demo.repository;

import com.example.demo.entity.SteamerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface SteamerRepository extends CrudRepository<SteamerEntity, Integer> {
    List<SteamerEntity> findSteamerEntitiesByTrainEntity_TrainID(Integer id);

}
