package com.evol.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class ThermItem {

    @JSONField(name="CurrentHumidity")
    private ThermHumidity currentHumidity;

    @JSONField(name="CurrentTemperature")
    private ThermTemp currentTemperature;

    @JSONField(name="GeoLocation")
    private ThermGeoLocation geoLocation;

}







