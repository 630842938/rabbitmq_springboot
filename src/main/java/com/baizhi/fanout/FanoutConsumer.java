package com.baizhi.fanout;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author llh
 * @Date 2020/6/28 --- 17:16
 */
@Component
public class FanoutConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,                                             //临时队列
                    exchange =  @Exchange(value = "logs",type = "fanout")       //绑定的交换机
            )
    })
    public void receive1(String message){
        System.out.println("message1 = " + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,                                             //临时队列
                    exchange =  @Exchange(value = "logs",type = "fanout")       //绑定的交换机
            )
    })
    public void receive2(String message){
        System.out.println("message2 = " + message);
    }
}






