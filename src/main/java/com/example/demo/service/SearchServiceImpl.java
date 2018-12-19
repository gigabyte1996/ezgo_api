package com.example.demo.service;

import com.example.demo.entity.TrainScheduleEntity;
import com.example.demo.model.Search;
import com.example.demo.model.TrainSchedule;
import com.example.demo.service.SearchService;
import com.example.demo.service.response.MessageResponse;
import com.example.demo.service.response.TrainScheduleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@Service
public class SearchServiceImpl implements SearchService {


    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private TrainServiceImpl trainService;


    @Override
    public TrainScheduleResponse searchTrainScheduleByCode(Search search) {
        TrainScheduleResponse TrainScheduleResponse = new TrainScheduleResponse();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        //search TrainSchedule by name
        CriteriaQuery<TrainScheduleEntity> criteriaQueryTrainSchedule = criteriaBuilder.createQuery(TrainScheduleEntity.class);
        Root<TrainScheduleEntity> trainScheduleEntityRoot = criteriaQueryTrainSchedule.from(TrainScheduleEntity.class);
        CriteriaQuery<TrainScheduleEntity> selectG = criteriaQueryTrainSchedule.where(criteriaBuilder.like(trainScheduleEntityRoot.get("trainScheduleCode"), "%" + search.getKey() + "%"));
        selectG.orderBy(criteriaBuilder.asc(trainScheduleEntityRoot.get("trainScheduleCode")));
        TypedQuery<TrainScheduleEntity> typedQueryG = entityManager.createQuery(selectG);
        List<TrainScheduleEntity> trainScheduleEntityListFound = typedQueryG.getResultList();
        List<TrainSchedule> TrainScheduleListFound = trainService.parseListTrainScheduleEntityToListTrainSchdeduleModel(trainScheduleEntityListFound);


        TrainScheduleResponse.setSingleTrainSchedules(TrainScheduleListFound);
        TrainScheduleResponse.setError(new MessageResponse(0,"Success"));
        return TrainScheduleResponse;
    }
}
