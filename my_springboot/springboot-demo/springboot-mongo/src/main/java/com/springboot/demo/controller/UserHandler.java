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

    @GetMapping("/list")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public User findById(@PathVariable String id) {
        return userRepository.getById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody User user) {
        userRepository.save(user);
    }

    @PostMapping("/save")
    public void save(@RequestBody User user) {
        userRepository.save(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        userRepository.deleteById(id);
    }
}
