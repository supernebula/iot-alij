package com.evol;

import com.aliyun.openservices.ons.api.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class RMqConsumerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RMqConsumerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Properties properties = new Properties();
        // 您在控制台创建的 Group ID
        properties.put(PropertyKeyConst.GROUP_ID, "GID_TCP_TEST_SERVICE1");
        // 鉴权用 AccessKeyId，在阿里云服务器管理控制台创建
        properties.put(PropertyKeyConst.AccessKey, "LTAI4FevWzDPTiVYfz6MhNQb");
        // 鉴权用 AccessKeySecret，在阿里云服务器管理控制台创建
        properties.put(PropertyKeyConst.SecretKey, "8NTfrCeVp6F3t9D5QMQpR6XWfrzTih");
        // 设置 TCP 接入域名，进入控制台的实例管理页面，在页面上方选择实例后，在实例信息中的“获取接入点信息”区域查看
        properties.put(PropertyKeyConst.NAMESRV_ADDR,"http://MQ_INST_1814113004274295_BbtV4klE.mq-internet-access.mq-internet.aliyuncs.com:80");

        Consumer consumer = ONSFactory.createConsumer(properties);
//        consumer.subscribe("TOPIC_TEST_PUBLIC", "*", new MessageListener() {
//            public Action consume(Message message, ConsumeContext context) {
//                System.out.println("Receive: " + message);
//                return Action.CommitMessage;
//            }
//        });

        consumer.subscribe("TOPIC_TEST_PUBLIC", "*", (message, context) -> {
            System.out.println("Receive: " + message);
            System.out.println("Receive Message Body: " + new String(message.getBody()));
            return Action.CommitMessage;
        });

        consumer.start();
        System.out.println("Consumer Started");
    }
}
