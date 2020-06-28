package com.baizhi.test;

import com.baizhi.RabbitmqSpringbootApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author llh
 * @Date 2020/6/28 --- 16:01
 */

@SpringBootTest(classes = RabbitmqSpringbootApplication.class)
@RunWith(SpringRunner.class)
public class TestRabbitMQ {

    //注入RabbitTemplate
    @Autowired
    private RabbitTemplate rabbitTemplate;

    //hello world
    @Test
    public void testHello(){
        rabbitTemplate.convertAndSend("hello","hello world");
    }

    //work
    @Test
    public void testWork(){
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work","work模型"+i);
        }
    }

    //fanout 广播
    @Test
    public void testFanout(){
        rabbitTemplate.convertAndSend("logs","","fanout模型传递的消息");
    }

    //route 路由模式
    @Test
    public void testRoute(){
        rabbitTemplate.convertAndSend("directs","info","发送info的key的info路由信息");
        rabbitTemplate.convertAndSend("directs","error","发送info的key的error路由信息");
        rabbitTemplate.convertAndSend("directs","warn","发送info的key的warn路由信息");
    }

    //route 动态路由 订阅模式
    @Test
    public void testTopic(){
        rabbitTemplate.convertAndSend("topics","user.save","user.save 路由信息");
        rabbitTemplate.convertAndSend("topics","user.save.saveall","user.save.saveall 路由信息");
        rabbitTemplate.convertAndSend("topics","user.save","user.save 路由信息");
    }
}
