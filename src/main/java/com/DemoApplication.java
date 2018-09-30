package com;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
//定时器
@EnableScheduling
//将项目中对应的mapper类的路径加进来就可以了
@MapperScan("com.dao")
public class DemoApplication extends SpringBootServletInitializer {
    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    String name = "World";

    @RequestMapping("/")
    public String home(){
        return "Hello " + name;
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder){
        return springApplicationBuilder.sources(DemoApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }






}
