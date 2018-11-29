package com.example.demo.repository;

import com.example.demo.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {
//    CustomerEntity findCustomerEntitiesByCustomerID(Integer id);
    CustomerEntity findCustomerEntityByCustomerID(Integer id);
    List<CustomerEntity> findAll();
}
