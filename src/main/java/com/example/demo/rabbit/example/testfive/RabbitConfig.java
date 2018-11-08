package com.example.demo.rabbit.example.testfive;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(value = "fiveConfig")
public class RabbitConfig {

    /**
     * @apiNote 定义主题交换器
     * @return
     */
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topic-exchange");
    }

    /**
     * @apiNote 定义自动删除匿名队列
     * @return
     */
    @Bean
    public Queue autoDeleteQueue0() {
        Queue autoDeleteQueue0 = new AnonymousQueue();
        return autoDeleteQueue0;
    }

    /**
     * @apiNote 定义自动删除匿名队列
     * @return
     */
    @Bean
    public Queue autoDeleteQueue1() {
        Queue autoDeleteQueue1 = new AnonymousQueue();
        return autoDeleteQueue1;
    }

    /**
     * @param topicExchange 主题交换器
     * @param autoDeleteQueue0 自动删除队列
     * @apiNote 绑定使用路由键为 orange 的 autoDeleteQueue0 队列到主题交换器上
     * @return Binding
     */
    @Bean
    public Binding binding0a(TopicExchange topicExchange, Queue autoDeleteQueue0) {
        return BindingBuilder.bind(autoDeleteQueue0).to(topicExchange).with("*.orange.*");
    }

    /**
     * @param topicExchange 主题交换器
     * @param autoDeleteQueue1 自动删除队列
     * @apiNote 绑定使用路由键为 black 的 autoDeleteQueue1 队列到主题交换器上
     * @return Binding
     */
    @Bean
    public Binding binding1a(TopicExchange topicExchange, Queue autoDeleteQueue1) {
        return BindingBuilder.bind(autoDeleteQueue1).to(topicExchange).with("*.*.rabbit");
    }

    /**
     * @param topicExchange 主题交换器
     * @param autoDeleteQueue1 自动删除队列
     * @apiNote 绑定使用路由键为 green 的 autoDeleteQueue1 队列到主题交换器上
     * @return Binding
     */
    @Bean
    public Binding binding1b(TopicExchange topicExchange, Queue autoDeleteQueue1) {
        return BindingBuilder.bind(autoDeleteQueue1).to(topicExchange).with("lazy1.#");
    }

}
