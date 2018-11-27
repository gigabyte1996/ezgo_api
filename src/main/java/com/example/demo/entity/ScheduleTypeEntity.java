package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ScheduleType")
public class ScheduleTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scheduleTypeID")
    private Integer scheduleTypeID;

    @Basic
    @Column(name = "scheduleTypeName")
    private String scheduletypeName;

    @Basic
    @Column(name = "scheduleTypeDescription")
    private String scheduleTypeNameDescription;

    @OneToMany(mappedBy = "scheduleTypeEntity", cascade = CascadeType.ALL)
    private List<FareScheduleEntity> fareScheduleEntities;


}
