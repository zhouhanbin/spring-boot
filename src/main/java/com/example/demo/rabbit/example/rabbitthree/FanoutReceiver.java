package com.example.demo.rabbit.example.rabbitthree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceiver {

    protected static Logger logger=LoggerFactory.getLogger(FanoutReceiver.class);

    @RabbitListener(queues = "#{AMessage.name}")
    public void process(String message) {
        logger.info("fanout Receiver AA  : " + message);

    }

    @RabbitListener(queues = "#{AMessage.name}")
    public void process1(String message) {
        logger.info("fanout Receiver BB  : " + message);

    }

    @RabbitListener(queues = "#{AMessage.name}")
    public void process2(String message) {
        logger.info("fanout Receiver CC  : " + message);

    }
}
