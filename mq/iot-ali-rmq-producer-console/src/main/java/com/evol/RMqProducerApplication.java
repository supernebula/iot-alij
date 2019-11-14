package com.evol;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.SendResult;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class RMqProducerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RMqProducerApplication.class, args);
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

        Producer producer = ONSFactory.createProducer(properties);
        producer.start();

        int number = 1;
        while (number++ < 100){
            Message message = new Message("TOPIC_TEST_PUBLIC", "tag1", "key1", ("msg test1 body" + number).getBytes());

            SendResult sendResult = producer.send(message);
            System.out.println(number + " | Send Message success. Message ID is: " + sendResult.getMessageId());
            Thread.currentThread().sleep(1000);
        }

        producer.shutdown();
    }
}
