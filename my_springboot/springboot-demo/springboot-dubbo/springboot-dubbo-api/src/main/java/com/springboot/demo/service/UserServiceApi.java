package com.springboot.demo.service;

import com.springboot.demo.entity.User;

import java.util.List;

public interface UserServiceApi {
    List<User> findAll();
    User findById(Long id);
}
