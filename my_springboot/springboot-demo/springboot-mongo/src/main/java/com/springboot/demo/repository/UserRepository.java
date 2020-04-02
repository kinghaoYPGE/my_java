package com.springboot.demo.repository;

import com.springboot.demo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User getById(String id);

}
