package com.springboot.demo.receiver;

import com.rabbitmq.client.Channel;
import com.springboot.demo.entity.User;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class UserReceiver {

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "user-queue"),
                    exchange = @Exchange(value = "user-exchange", type = "topic"),
                    key = "user.#"
            )
    )
    @RabbitHandler
    public void onMessage(@Payload User user,
                          @Headers Map<String ,Object> headers,
                          Channel channel) throws IOException {
        System.err.println("消费者开始消费");
        System.err.println("用户ID：" + user.getId());
        // 手动签收，反馈消息到发送者
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(deliveryTag, false);

    }

}
