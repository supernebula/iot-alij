package com.evol.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class ThermGeoLocation
{
    @JSONField(name="value")
    public ThermGeoValue value;

    @JSONField(name="time")
    public long time;
}
