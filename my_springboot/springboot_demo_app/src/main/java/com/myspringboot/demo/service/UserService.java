package com.myspringboot.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myspringboot.demo.model.User;
import com.myspringboot.demo.dao.UserRepository;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // @Transactional(rollbackFor = Exception.class)
    // 切换为spring aop进行事务控制
    public User save(User user) {
        // 保存实体类
        userRepository.save(user);
        //制造异常，测试springboot中的事务处理
        int flag = 1 / 0;
        user.setPassword("123456");
        //重新保存，更新记录
        return userRepository.save(user);
    }

}