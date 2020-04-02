package com.springboot.demo.repository;


import com.springboot.demo.entity.first.User;
import com.springboot.demo.entity.other.UserOther;
import com.springboot.demo.repository.first.UserRepository;
import com.springboot.demo.repository.other.UserOtherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserOtherRepository userOtherRepository;

    @Test
    public void testInsert() {
        User user = new User(3L, "testInsert", 19);
        userRepository.save(user);
    }

    @Test
    public void testUpdate() {
        UserOther userOther = new UserOther(2L, "testUpdate", 28);
        userOtherRepository.save(userOther);
    }

    @Test
    public void testDelete(User user) {
        userRepository.delete(user);
    }

    @Test
    public void testFindAll() {
        List<User> users = userRepository.findAll();
        List<UserOther> userOthers = userOtherRepository.findAll();
        System.out.println(users);
        System.out.println("others: " + userOthers);
    }

}