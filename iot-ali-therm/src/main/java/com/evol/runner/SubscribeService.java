package com.evol.runner;

import com.aliyun.mns.client.CloudAccount;
import com.aliyun.mns.client.CloudQueue;
import com.aliyun.mns.client.MNSClient;
import com.aliyun.mns.model.Message;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class SubscribeService
{

    private static final String accessKeyId = "LTAI4FevWzDPTiVYfz6MhNQb";
    private static final String accessKeySecret = "8NTfrCeVp6F3t9D5QMQpR6XWfrzTih";
    private static final String endpoint = "https://1814113004274295.mns.cn-shanghai.aliyuncs.com/";
    private static final String queueName = "aliyun-iot-a1lH5vdBSs8";
    private MNSClient client = null;

    SubscribeService()
    {
        CloudAccount account = new CloudAccount(accessKeyId, accessKeySecret, endpoint);
        client = account.getMNSClient();
    }


    public void handMessage(){
        CloudQueue queue = client.getQueueRef(queueName);
        while (true){
            Message popMsg = queue.popMessage(10);
            if(popMsg == null){
                System.out.println("Continuing");
                continue;
            }

            String body = popMsg.getMessageBody();
            System.out.println(body);

            String receiptHandle = popMsg.getReceiptHandle();
            queue.deleteMessage(receiptHandle);
        }
    }
}
