package com.springboot.demo.repository;

import com.springboot.demo.entity.User;

import java.util.List;

public interface UserRepository {

    List<User> findAll();
    void save(User user);
    void update(User user);
    User findById(Long id);
    void deleteById(Long id);

}
