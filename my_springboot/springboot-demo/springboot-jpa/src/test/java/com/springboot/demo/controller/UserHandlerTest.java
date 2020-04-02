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

    private static String url = "http://localhost:8099/user";

    @Test
    void findAll() {
        List users = restTemplate.getForObject(url + "/list", List.class);
        System.out.println(users);
    }

    @Test
    void findById() {
        User user = restTemplate.getForObject(url + "/find/{id}", User.class, 3L);
        System.out.println(user);
    }

    @Test
    void update() {
        restTemplate.put(url+"/update",
                new User(3L, "dataJpaTest", 88));
        User user = restTemplate.getForObject(url + "/find/{id}", User.class, 3L);
        System.out.println(user);
    }

    @Test
    void save() {
        restTemplate.postForObject(url + "/save",
                new User(4L, "dataJpaTest2", 99), User.class);
        User user = restTemplate.getForObject(url + "/find/{id}", User.class, 4L);
        System.out.println(user);
    }

    @Test
    void delete() {
        restTemplate.delete(url+"/delete/{id}", 4L);
        List users = restTemplate.getForObject(url + "/list", List.class);
        System.out.println(users);
    }
}