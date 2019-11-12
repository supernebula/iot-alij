package com.evol.message;

import com.evol.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DeviceInstructConsumer {

//    @RabbitListener(queues = RabbitMqConfig.QUEUE_NAME)
//    public void consumeMessage(String message) {
//        DeviceInstructMessage msg = evol.util.JSONUtil.parseObject(message, DeviceInstructMessage.class);
//        if(msg == null) System.out.println("错误的消息格式");
//
//        System.out.println("consume message, messageId:" + msg.getMessageId() + ",  body: " + msg.getInstructBody());
//    }

    @RabbitListener(bindings = {@QueueBinding(exchange =  @Exchange(RabbitMqConfig.EXCHANGE_NAME), key = {RabbitMqConfig.ROUTING_KEY}, value = @Queue(RabbitMqConfig.QUEUE_NAME))})
    public void consume(String message) {
        DeviceInstructMessage msg = evol.util.JSONUtil.parseObject(message, DeviceInstructMessage.class);
        if(msg == null) System.out.println("错误的消息格式");

        System.out.println("consume message, messageId:" + msg.getMessageId() + ",  body: " + msg.getInstructBody());
    }
}
