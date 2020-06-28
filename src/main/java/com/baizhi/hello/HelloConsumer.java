package com.baizhi.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author llh
 * @Date 2020/6/28 --- 16:06
 */
@Component
@RabbitListener(queuesToDeclare = @Queue(value = "hello"))
public class HelloConsumer {

    @RabbitHandler
    public void receive(String message){
        System.out.println("message=" + message);
    }
}
