package com.example.demo;

import com.example.demo.entitites.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByName(String name);
}
