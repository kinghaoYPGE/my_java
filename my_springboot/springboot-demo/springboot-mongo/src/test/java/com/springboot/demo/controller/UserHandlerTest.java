package com.springboot.demo.controller;

import com.springboot.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootTest
class UserHandlerTest {

    @Autowired
    private RestTemplate restTemplate;

    private static String url = "http://localhost:9000/user";

    @Test
    void findAll() {
        List users = restTemplate.getForObject(url + "/list", List.class);
        System.out.println(users);
    }

    @Test
    void findById() {
        User user = restTemplate.getForObject(url + "/find/{id}", User.class, "5c7d06b69c68af1b9cc86296");
        System.out.println(user);
    }

    @Test
    void update() {
        restTemplate.put(url+"/update",
                new User("5c7d06b69c68af1b9cc86296", "mongoTest1", 22));
        User user = restTemplate.getForObject(url + "/find/{id}", User.class, "5c7d06b69c68af1b9cc86296");
        System.out.println(user);
    }

    @Test
    void save() {
        restTemplate.postForObject(url + "/save",
                new User(null, "mongoTest333", 22), User.class);
    }

    @Test
    void delete() {
        restTemplate.delete(url+"/delete/{id}", "5de394e486413e32b963f4f6");
        List users = restTemplate.getForObject(url + "/list", List.class);
        System.out.println(users);
    }
}