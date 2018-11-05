package com.example.demo.rabbit.example.testone;

import com.example.demo.rabbit.example.entity.ObjectData;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class HelloSender {

    @Autowired
    private Queue dateQueue;
    @Autowired
    private Queue objQueue;
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String massage) {
        System.out.println("发送 : " + massage);
        rabbitTemplate.convertAndSend(dateQueue.getName(), massage);
    }

    public void sendObj(ObjectData user) {
        System.out.println("发送 : " + user);
        rabbitTemplate.convertAndSend(objQueue.getName(), user);
    }

}
