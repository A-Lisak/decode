
package com.decode.anpr.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Speed {

    private Integer radarSpeed = 0;

    private String radarSpeedUnits = "";

    private List<RadarRawSpeed> radarRawSpeeds = new ArrayList<RadarRawSpeed>();

}
