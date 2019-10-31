package com.evol.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class ThermGeoValue
{
    @JSONField(name="CoordinateSystem")
    public int CoordinateSystem;

    @JSONField(name="Latitude")
    public double Latitude;

    @JSONField(name="Longitude")
    public double Longitude;

    @JSONField(name="Altitude")
    public double Altitude;

}
