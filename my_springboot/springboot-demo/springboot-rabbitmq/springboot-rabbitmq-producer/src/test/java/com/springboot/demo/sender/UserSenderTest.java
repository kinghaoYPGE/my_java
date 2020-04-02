package com.springboot.demo.sender;

import com.springboot.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserSenderTest {
    @Autowired
    UserSender userSender;

    @Test
    void send() {
        for(long i=1; i<100; i++) {
            User user = new User(i, "rabbitmq-test"+i, 10,
                    System.currentTimeMillis()+ UUID.randomUUID().toString());
            userSender.send(user);
        }

    }
}