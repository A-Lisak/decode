package com.decode.anpr.impl;

import com.decode.anpr.config.JsonMapper;
import com.decode.anpr.model.AnprResponse;
import com.decode.anpr.service.DecodesService;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.apache.http.HttpHeaders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWireMock(port = 8082)
public class DecodesServiceImplTest {
    public static final String ANPRMON_DECODES_0 = "/ANPRMon/decodes/0";
    @Autowired
    private DecodesService decodesService;

    @Test
    public void getDecodes()  {
        final String decodesResponseJson = JsonMapper.getResource("decodes-data.json");
        stubFor(WireMock.get(urlPathMatching(ANPRMON_DECODES_0))
                .willReturn(aResponse()
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBody(decodesResponseJson)));

        AnprResponse anprResponse = decodesService.getDecodes("AV12LPR");
        assertThat(anprResponse).isNotNull();
        assertThat(anprResponse.isEntered()).isTrue();
        assertThat(anprResponse.isExited()).isFalse();
    }
}