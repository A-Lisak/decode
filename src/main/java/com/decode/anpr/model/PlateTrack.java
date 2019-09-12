
package com.decode.anpr.model;

import lombok.Data;

@Data
public class PlateTrack {

    private Integer charHeight;

    private Integer frameID;

    private PlatePos platePos;

    private Integer plateWidth;

}
