package com.evol.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class Payload {

    @JSONField(name = "deviceType")
    private String deviceType;

    @JSONField(name = "iotId")
    private String iotId;

    @JSONField(name = "requestId")
    private String requestId;

    @JSONField(name = "productKey")
    private String productKey;

    @JSONField(name = "gmtCreate")
    private String gmtCreate;

    @JSONField(name = "deviceName")
    private String deviceName;

    @JSONField(name = "Items")
    private ThermItem Items;

}
