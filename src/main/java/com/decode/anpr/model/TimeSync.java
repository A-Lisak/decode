
package com.decode.anpr.model;

import lombok.Data;

@Data
public class TimeSync {

    private Integer timeMode;

    private Integer lastSyncTime;

    private String lastSyncSource;

    private String lastSyncInfo;

}
