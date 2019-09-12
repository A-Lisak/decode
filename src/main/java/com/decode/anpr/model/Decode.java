
package com.decode.anpr.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Decode {

    private String safid;

    private Long ref;

    private String vrm;

    private Integer frameID;

    private String spacedVRM;

    private Integer seenCount;

    private Long serialNo;

    private String mac;

    private String cameraName;

    private Integer decodeID;

    private Integer charHeight;

    private Location location;

    private Boolean repeatedPlate;

    private TimeStamp timeStamp;

    private TimeSync timeSync;

    private Integer confidence;

    private Boolean correctSpacing;

    private String countryCode;

    private Boolean preferredCountry;
 
    private Boolean preferredFormat;

    private String syntax;

    private Integer direction;

    private String motion;

    private LaneInfo laneInfo;

    private AccessoryStatus accessoryStatus;

    private Integer frameTimeRef;

    private Boolean nightModeActive;

    private Integer frameHeight;

    private Integer frameWidth;

    private PlateRect plateRect;

    private Boolean zoomLocked;

    private Integer overviewSource;

    private Integer overviewScale;
  
    private OverviewRect overviewRect;

    private OverviewPlateRect overviewPlateRect;

    private List<PlateTrack> plateTrack = new ArrayList<>();

    private List<RawRead> rawReads = new ArrayList<>();
 
    private Speed speed;

    private String radarDiags;
 
    private String plate;

    private String overview;
    
}
