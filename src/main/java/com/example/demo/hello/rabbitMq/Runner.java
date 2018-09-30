package com.example.demo.hello.rabbitMq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Runner implements CommandLineRunner {
    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    public Runner(RabbitTemplate rabbitTemplate, Receiver receiver) {
        this.rabbitTemplate = rabbitTemplate;
        this.receiver = receiver;
    }

    @Override
    public void run(String... args) throws Exception{
        System.out.println("Sending message...");
//        rabbitTemplate.convertAndSend(DemoApplication.topicExchangeName,"foo.bar.baz","Hello from RabbitMq");
//        receiver.getLatch().await(10000,TimeUnit.MILLISECONDS);
    }
}
