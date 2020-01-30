package com.example.mockrestserver.mockrestserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;
import static java.util.Arrays.asList;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
public class ExampleRestService {
    private final RestTemplate restTemplate;

    @Autowired
    public ExampleRestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    HTMessageVO getMessageById(String messageId) throws ResourceAccessException {
        Map<String, Object> data = new HashMap<>();
        data.put("id", messageId);
        String mcoUrl = format("http://%s:%s/v1/", "10.230.14.253", "8080");
        RestClient rest = new RestClient(restTemplate, mcoUrl);
        HTMessageRestResultVO response = rest.post(HTMessageRestResultVO.class, "fms/msg/show", data);
        return response.getResults().get(0).getData().get(0);
    }

    public String getRootResource() {
        Map<String, Object> requestEntity = new HashMap<>();
        requestEntity.put("id", "e20fef6e-f3da-e961-a796-00000000531d");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(APPLICATION_JSON);
        httpHeaders.setAccept(asList(APPLICATION_JSON));
        HttpEntity<?> entity = new HttpEntity<>(requestEntity, httpHeaders);
        ResponseEntity<byte[]> response = new RestTemplate().postForEntity("http://10.230.14.253:8080/v1/fms/msg/show", entity, byte[].class);
        new RestTemplate().postForEntity("http://10.230.14.253:8080/v1/fms/msg/show", entity, byte[].class);
        new RestTemplate().postForEntity("http://10.230.14.253:8080/v1/fms/msg/show", entity, byte[].class);
        new RestTemplate().postForEntity("http://10.230.14.253:8080/v1/fms/msg/show", entity, byte[].class);
        new RestTemplate().postForEntity("http://10.230.14.253:8080/v1/fms/msg/show", entity, byte[].class);
        new RestTemplate().postForEntity("http://10.230.14.253:8080/v1/fms/msg/show", entity, byte[].class);
        new RestTemplate().postForEntity("http://10.230.14.253:8080/v1/fms/msg/show", entity, byte[].class);
        new RestTemplate().postForEntity("http://10.230.14.253:8080/v1/fms/msg/show", entity, byte[].class);
        new RestTemplate().postForEntity("http://10.230.14.253:8080/v1/fms/msg/show", entity, byte[].class);
        System.out.println("getRootResource: " + response);

        return response.toString();
    }
}
