package com.springboot.demo.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.springboot.demo.entity.User;
import com.springboot.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service(version = "1.0.0", timeout = 10000, interfaceClass = UserServiceApi.class)
public class UserServiceImpl implements UserServiceApi {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.getById(id);
    }
}
