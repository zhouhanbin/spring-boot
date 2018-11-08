package com.example.demo.rabbit.example.testfive;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "fiveProducer")
public class Producer {

    @Autowired
    private TopicExchange topicExchange;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private String[] keys = {"quick.orange.rabbit",
            "lazy.orange.elephant", "quick.orange.fox", "lazy.brown.fox","lazy1.pink.message","quick.brown.fox"};

    public void send() {
        String message = "哈哈哈";
        for (int i = 0; i < 5; i++) {
            System.out.println("send++++++++++:".concat(message));
            rabbitTemplate.convertAndSend(topicExchange.getName(), keys[4], message);
        }
    }

}
