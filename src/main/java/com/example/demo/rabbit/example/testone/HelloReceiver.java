package com.example.demo.rabbit.example.testone;

import com.example.demo.rabbit.example.entity.ObjectData;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HelloReceiver {

    @RabbitListener(queues = "date")
    public void processDate(String date) {
        System.out.println("消费信息 ==================: " + date);
    }

    @RabbitListener(queues = "object")
    public void processObj(ObjectData user) {
        System.out.println("接受消费信息 ==================: " + user);
        System.out.println("接受消费信息 ==================: " + user.getName());
        System.out.println("接受消费信息 ==================: " + user.getSex());
    }


}
