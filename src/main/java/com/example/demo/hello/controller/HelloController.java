package com.example.demo.hello.controller;

import com.example.demo.hello.rabbitMq.Producer;
import com.example.demo.hello.rabbitMq.Receiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello World";
    }
    private final static Logger logger = LoggerFactory.getLogger(HelloController.class);


    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    private Producer producer;

    private Receiver receiver;

    @RequestMapping(value = "/test/{msg}",method = RequestMethod.GET)
    public String test(@PathVariable(value = "msg") String msg){
        logger.info("#TestController.Send#abc={msg}", msg);
        producer.sendDataToQueue("foo.bar.baz",msg);
//        rabbitTemplate.convertAndSend("spring-boot-exchange","foo.bar.baz",msg);
        return msg;
    }


    /**
     * 单生产者-多消费者
     */
    @RequestMapping("/oneToMany")
    public void oneToMany() {
        for(int i=0;i<10;i++){
            System.out.println("执行"+i);
//            helloSender1.Send("hellomsg:"+i);
        }

    }


}
