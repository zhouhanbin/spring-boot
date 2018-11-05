package com.example.demo.rabbit.example.rabbitthree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutSender {
    protected static Logger logger=LoggerFactory.getLogger(FanoutSender.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hi, fanout msg ";
        for (int i = 0; i < 10; i++) {
            logger.info("Sender : " + context+i);
            this.rabbitTemplate.convertAndSend("fanoutExchange","", context+i);
        }
    }

}
