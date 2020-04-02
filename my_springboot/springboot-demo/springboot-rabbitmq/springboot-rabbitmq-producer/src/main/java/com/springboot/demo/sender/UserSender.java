package com.springboot.demo.sender;

import com.springboot.demo.entity.User;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(User user) {

        rabbitTemplate.convertAndSend(
                "user-exchange",
                "user.test",
                user,
                new CorrelationData(user.getMessageId())
        );

    }
}
