package com.springboot.demo.repository;

import com.springboot.demo.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User getById(Long id);
}
