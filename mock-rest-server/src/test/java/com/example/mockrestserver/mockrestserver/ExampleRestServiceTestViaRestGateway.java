package com.example.mockrestserver.mockrestserver;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.support.RestGatewaySupport;

import java.util.Collections;

import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExampleRestServiceTestViaRestGateway {

    RestTemplate restTemplate;
    ExampleRestService service;

    private MockRestServiceServer mockServer;

    @Before
    public void setUp() {
        RestTemplate restTemplate = new RestTemplate();
        this.restTemplate = restTemplate;
        this.service = new ExampleRestService(restTemplate);
        RestGatewaySupport gateway = new RestGatewaySupport();
        gateway.setRestTemplate(this.restTemplate);
        mockServer = MockRestServiceServer.createServer(gateway);
    }

    @Test
    public void getMessageById() {
        mockServer.reset();
        String messageId = "decf30b4-d5dd-e961-a796-00000000531d";
        String messageSme = "SMPP_TEST:#SALA:4";

        mockServer.expect(once(), requestTo("http://10.230.14.253:8080/v1/fms/msg/show")).
        andExpect(method(HttpMethod.POST))
                .andRespond(withSuccess("{\n" +
                                "    \"results\": [\n" +
                                "        {\n" +
                                "            \"class\": \"kernel\",\n" +
                                "            \"instance\": \"kernel-00\",\n" +
                                "            \"code\": \"OK\",\n" +
                                "            \"originator_timestamp_utc_millis\": \"1569234781272\",\n" +
                                "            \"data\": [\n" +
                                "                {\n" +
                                "                    \"id\": \"decf30b4-d5dd-e961-a796-00000000531d\",\n" +
                                "                    \"orig\": \"1.1.357496468\",\n" +
                                "                    \"recip\": \"1.1.910\",\n" +
                                "                    \"sme\": \"MY_SME\",\n" +
                                "                    \"dst_aim\": \"SMPP_TEST\",\n" +
                                "                    \"submit_time\": \"2019-09-23 07:42:33.000+0000\",\n" +
                                "                    \"scheduled_time\": \"never\",\n" +
                                "                    \"expiry_time\": \"2019-09-24 07:42:33.000+0000\",\n" +
                                "                    \"last_delivery_time\": \"never\",\n" +
                                "                    \"final_time\": \"never\",\n" +
                                "                    \"priority\": \"0\",\n" +
                                "                    \"importance\": \"0\",\n" +
                                "                    \"text\": \"***\",\n" +
                                "                    \"content\": \"***\",\n" +
                                "                    \"udh\": \"***\",\n" +
                                "                    \"suspend_time\": \"never\",\n" +
                                "                    \"nr_suspended\": \"0\",\n" +
                                "                    \"await_receipt\": \"no\",\n" +
                                "                    \"isr_id\": \"N/A\"\n" +
                                "                }\n" +
                                "            ]\n" +
                                "        }\n" +
                                "    ]\n" +
                                "}",
                        MediaType.APPLICATION_JSON));
        HTMessageVO result = service.getMessageById(messageId);
        System.out.println(result);
        mockServer.verify();
    }

}