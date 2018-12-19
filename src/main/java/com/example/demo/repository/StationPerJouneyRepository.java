package com.example.demo.repository;

import com.example.demo.entity.StationPerJourneyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface StationPerJouneyRepository extends CrudRepository<StationPerJourneyEntity, Integer> {
    List<StationPerJourneyEntity> findStationPerJourneyEntitiesByTrainScheduleEntity_TrainScheduleIDOrderByDepartureTimeAsc(Integer trainScheduleID);

}
