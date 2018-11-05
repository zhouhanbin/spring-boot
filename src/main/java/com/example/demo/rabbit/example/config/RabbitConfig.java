package com.example.demo.rabbit.example.config;

import com.example.demo.rabbit.example.testtow.WorkReceiver;
import com.example.demo.rabbit.example.testtow.WorkSend;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {

    @Bean
    public Queue workQueue() {
        return new Queue("work-queue");
    }

    @Bean
    public WorkReceiver workReceiver() {
        return new WorkReceiver("Receiver0");
    }
    @Bean
    public WorkReceiver workReceiver123() {
        return new WorkReceiver("Receiver1");
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setPrefetchCount(0);
        return factory;
    }
    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory =  new CachingConnectionFactory("127.0.0.1", 5672);
        cachingConnectionFactory.setUsername("guest");
        cachingConnectionFactory.setPassword("guest");
        return cachingConnectionFactory;
    }




    @Bean
    public WorkSend workSend() {
        return new WorkSend();
    }


    @Bean
    public Queue dateQueue() {
        return new Queue("date");
    }

    @Bean
    public Queue objQueue() {
        return new Queue("object");
    }

}
