package com.decode.anpr.service.impl;

import com.decode.anpr.client.DecodesClient;
import com.decode.anpr.exception.NotFoundException;
import com.decode.anpr.model.AnprResponse;
import com.decode.anpr.model.Decode;
import com.decode.anpr.model.DecodesResponse;
import com.decode.anpr.service.DecodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DecodesServiceImpl implements DecodesService {

    @Value("${anprdecodes.function}")
    private String decodes;

    @Value("${anprdecodes.ref}")
    private Long ref;

    @Autowired
    private DecodesClient decodesClient;

    @Override
    public AnprResponse getDecodes(String vrm) throws NotFoundException {
        DecodesResponse decodesResponse = decodesClient.getDecodes(decodes, ref);

        List<Decode> decodes = decodesResponse.getDecodes().stream().filter(d -> d.getVrm().equals(vrm))
                .collect(Collectors.toList());
        if (decodes.isEmpty()) {
            throw new NotFoundException("da");
        }
        Decode latestDecode = decodes.stream().min(Comparator.comparing(Decode::getRef)).get();

        AnprResponse anprResponse = new AnprResponse();
        anprResponse.setSafid(latestDecode.getSafid());
        anprResponse.setRef(latestDecode.getRef());
        anprResponse.setVrm(latestDecode.getVrm());
        anprResponse.setSeenCount(latestDecode.getSeenCount());
        anprResponse.setTimeStamp(latestDecode.getTimeStamp());
        anprResponse.setDirection(latestDecode.getDirection());
        if (latestDecode.getDirection() == 0) {
            anprResponse.setEntered(true);
            anprResponse.setExited(false);
        } else if (latestDecode.getDirection() > 0) {
            anprResponse.setEntered(false);
            anprResponse.setExited(true);
        }

        return anprResponse;
    }
}
