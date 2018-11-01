package com.example.demo.repository;

import com.example.demo.entity.StationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface StationRepository extends CrudRepository<StationEntity, Integer> {
    List<StationEntity> findAll();
}
