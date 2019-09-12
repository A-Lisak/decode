
package com.decode.anpr.model;

import lombok.Data;

@Data
public class AnprResponse {

    private String safid;

    private Long ref;

    private String vrm;

    private Integer seenCount;

    private TimeStamp timeStamp;

    private Integer direction;

    private boolean entered;

    private boolean exited;
}
