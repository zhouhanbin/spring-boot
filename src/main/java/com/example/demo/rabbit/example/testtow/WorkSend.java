package com.example.demo.rabbit.example.testtow;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkSend {
    @Autowired
    private Queue workQueue;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {
        for (int i = 0; i < 10; i++) {
            String msg = "你好 " + i;
            System.out.println("send =====:".concat(msg));
            rabbitTemplate.convertAndSend(workQueue.getName(), msg);
        }
    }

}
