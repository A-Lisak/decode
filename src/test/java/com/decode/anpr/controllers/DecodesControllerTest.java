package com.decode.anpr.controllers;

import com.decode.anpr.config.JsonMapper;
import com.decode.anpr.model.AnprResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.apache.http.HttpHeaders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWireMock(port = 8081)
@AutoConfigureMockMvc
public class DecodesControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    @Qualifier("objectMapper")
    private ObjectMapper mapper;

    public static final String ANPRMON_DECODES_0 = "/ANPRMon/decodes/0";
    public static final String ANPR_REQUEST = "/vehicledirection/AV12LPR";

    @Test
    public void getVehicleDirection() throws Exception{
        final String decodesResponseJson = JsonMapper.getResource("decodes-data.json");
        stubFor(WireMock.get(urlPathMatching(ANPRMON_DECODES_0))
                .willReturn(aResponse()
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBody(decodesResponseJson)));

            MockHttpServletResponse response = mvc.perform(
                    get(ANPR_REQUEST))
                    .andExpect(status().isOk()).andReturn().getResponse();

        final AnprResponse anprResponse = mapper.readValue(response.getContentAsString(), AnprResponse.class);

        assertThat(anprResponse).isNotNull();
        assertThat(anprResponse.isEntered()).isTrue();
        assertThat(anprResponse.isExited()).isFalse();
    }
}