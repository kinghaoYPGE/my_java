package com.springboot.demo.repository;

import com.springboot.demo.entity.User;

import java.util.Collection;

public interface UserRepository {

    Collection<User> findAll();

    User findById(Long id);

    int update(User user);

    int save(User user);

    int deleteById(Long id);



}
