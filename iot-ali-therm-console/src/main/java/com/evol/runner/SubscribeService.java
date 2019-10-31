package com.evol.runner;

import com.aliyun.mns.client.CloudAccount;
import com.aliyun.mns.client.CloudQueue;
import com.aliyun.mns.client.MNSClient;
import com.aliyun.mns.model.Message;
import com.evol.model.DeviceMessage;
import com.evol.model.Payload;
import com.google.gson.annotations.JsonAdapter;
import evol.util.Base64Util;
import evol.util.JSONUtil;
import org.springframework.stereotype.Service;

@Service
public class SubscribeService {

    private static final String accessKeyId = "111";
    private static final String accessKeySecret = "222";
    private static final String endpoint = "https://xxxxxx.aliyuncs.com/";
    private static final String queueName = "aliyun-iot-xxxxxx";
    private MNSClient client = null;

    public SubscribeService()
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

            String bodyStr = popMsg.getMessageBody();
            System.out.println(bodyStr);
            DeviceMessage deviceMsg = JSONUtil.parseObject(bodyStr, DeviceMessage.class);
            System.out.println(deviceMsg);
            String payLoadStr = Base64Util.DecodeBase64(deviceMsg.getPayload());
            Payload payload = JSONUtil.parseObject(payLoadStr, Payload.class);
            System.out.println(payload);

            String receiptHandle = popMsg.getReceiptHandle();
            queue.deleteMessage(receiptHandle);
        }
    }
}
