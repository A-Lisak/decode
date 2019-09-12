package com.decode.anpr.client;

import com.decode.anpr.model.DecodesResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(
        name = "decodes",
        url = "${decodes.host}",
        path = "${decodes.path}")
public interface DecodesClient {
    @RequestMapping(value = "/{decodes}/{ref}", consumes = "application/json")
    DecodesResponse getDecodes(@PathVariable("decodes") String decodes, @PathVariable("ref") Long ref);

}