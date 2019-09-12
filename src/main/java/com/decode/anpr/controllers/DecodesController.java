package com.decode.anpr.controllers;

import com.decode.anpr.exception.NotFoundException;
import com.decode.anpr.model.AnprResponse;
import com.decode.anpr.service.DecodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DecodesController {
    @Autowired
    private DecodesService decodesService;

    @GetMapping("/vehicledirection/{vrm}")
    public ResponseEntity<AnprResponse> getVehicleDirection(@PathVariable("vrm") String vrm) throws NotFoundException {
        return new ResponseEntity<>(decodesService.getDecodes(vrm), HttpStatus.OK);
    }
}
