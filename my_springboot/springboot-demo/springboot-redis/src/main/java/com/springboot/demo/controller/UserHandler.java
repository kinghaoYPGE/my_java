package com.springboot.demo.controller;

import com.springboot.demo.entity.User;
import com.springboot.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/get/{key}")
    public User findById(@PathVariable String key) {
        return userRepository.get(key);
    }

    @PostMapping("/set")
    public void save(@RequestBody User user) {
        userRepository.set("user", user);
    }

    @DeleteMapping("/delete/{key}")
    public void delete(@PathVariable String key) {
        userRepository.delete(key);
    }
}
