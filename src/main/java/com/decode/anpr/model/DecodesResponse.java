
package com.decode.anpr.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DecodesResponse {

    private List<Decode> decodes = new ArrayList<>();

}
