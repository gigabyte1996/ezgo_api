package com.example.demo.repository;

import com.example.demo.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity findUserEntityByUsername(String username);
    UserEntity findUserEntityByUserID(Integer id);
}
