package com.springboot.demo.controller;

import com.springboot.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserHandlerTest {

    @Autowired
    private RestTemplate restTemplate;

    private static String url = "http://localhost:8092/user";

    @Test
    void findById() {
        User user = restTemplate.getForObject(url + "/get/{key}", User.class, "user");
        System.out.println(user);
    }

    @Test
    void save() {
        User user = new User(1L, "testRedis", 29);
        restTemplate.postForObject(url+"/set", user, User.class);
    }

    @Test
    void delete() {
        restTemplate.delete(url+"/delete/{key}", "user");
    }
}