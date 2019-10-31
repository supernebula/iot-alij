package com.evol.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class ThermHumidity
{
    @JSONField(name="value")
    private double value;

    @JSONField(name="time")
    private long time;

}