package com.example.demo.rabbit.example.rabbitthree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
//@RabbitListener(queues = "${BMessage.name}")
public class FanoutReceiverB {
    protected static Logger logger=LoggerFactory.getLogger(FanoutReceiverB.class);

    @RabbitHandler
    public void process(String message) {
        logger.info("fanout Receiver B  : " + message);

    }
}
