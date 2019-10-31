package com.evol.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class DeviceMessage {

    @JSONField(name = "messageid")
    private String messageId;

    @JSONField(name = "messagetype")
    private String messageType;

    @JSONField(name = "topic")
    private String topic;

    @JSONField(name = "payload")
    private String payload;

    @JSONField(name = "timestamp")
    private String timestamp;

}
