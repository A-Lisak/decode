
package com.decode.anpr.model;

import lombok.Data;

@Data
public class Location {

    private Integer latitude;

    private Integer longitude;

    private String name;

    private Integer source;

}
