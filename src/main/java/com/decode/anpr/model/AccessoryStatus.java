
package com.decode.anpr.model;

import lombok.Data;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//
//@Entity
@Data
public class AccessoryStatus {
//    @Id
//    @GeneratedValue
//    private int id;
    
    private Boolean _12VOut;

    private Boolean relayOut;

    private Boolean input;

    private Boolean _12VSense;
}
