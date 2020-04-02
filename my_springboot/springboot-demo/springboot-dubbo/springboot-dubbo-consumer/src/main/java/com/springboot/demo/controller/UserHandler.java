package com.springboot.demo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.springboot.demo.entity.User;
import com.springboot.demo.service.UserServiceApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {

    @Reference(version = "1.0.0")
    private UserServiceApi userServiceApi;

    @GetMapping("/find/{id}")
    public User find(@PathVariable Long id) {
        return userServiceApi.findById(id);
    }

    @GetMapping("/list")
    public List<User> findAll() {
        return userServiceApi.findAll();
    }
}
