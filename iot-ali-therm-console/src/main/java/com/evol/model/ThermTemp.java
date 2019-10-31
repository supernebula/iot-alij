package com.evol.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class ThermTemp
{
    @JSONField(name="value")
    public double Value;

    @JSONField(name="time")
    public long Time;
}