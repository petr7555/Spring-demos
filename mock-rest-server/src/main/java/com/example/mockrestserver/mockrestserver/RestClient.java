package com.example.mockrestserver.mockrestserver;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static java.util.Arrays.asList;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.MediaType.APPLICATION_JSON;

/**
 * Wraps {@link RestTemplate} for easier use.
 * Automatically sets accept json header, if not said otherwise (like postForMediaType).
 */
public class RestClient {

    private String defaultUrlPrefix;
    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;

    public RestClient(String defaultUrlPrefix) {
        this(new RestTemplate(), defaultUrlPrefix);
    }

    public RestClient(RestTemplate restTemplate, String defaultUrlPrefix) {
        this.defaultUrlPrefix = defaultUrlPrefix;
        this.restTemplate = restTemplate;
        this.objectMapper = new ObjectMapper();
    }

    public void put(String path) {
        put(Void.class, path, null);
    }

    public <T> T put(Class<T> clazz, String path, Object requestEntity) {
        HttpHeaders httpHeaders = new HttpHeaders();
        if (requestEntity != null) {
            httpHeaders.setContentType(APPLICATION_JSON);
        }
        HttpEntity<?> entity = new HttpEntity<>(requestEntity, httpHeaders);
        ResponseEntity<byte[]> response = restTemplate.exchange(defaultUrlPrefix + path, HttpMethod.PUT, entity, byte[].class);
        return convertResponse(response, clazz);
    }

    public <T> T get(Class<T> clazz, String path) {
        ResponseEntity<byte[]> response = restTemplate.exchange(defaultUrlPrefix + path, HttpMethod.GET, new HttpEntity(null), byte[].class);
        return convertResponse(response, clazz);
    }

    public <T> T post(Class<T> clazz, String path, Object requestEntity) {
        return postForMediaType(APPLICATION_JSON, clazz, path, requestEntity);
    }

    public <T> T postForMediaType(MediaType mediaType, Class<T> clazz, String path, Object requestEntity) {
        HttpHeaders httpHeaders = new HttpHeaders();
        if (requestEntity != null) {
            httpHeaders.setContentType(APPLICATION_JSON);
        }
        httpHeaders.setAccept(asList(mediaType));
        HttpEntity<?> entity = new HttpEntity<>(requestEntity, httpHeaders);
        ResponseEntity<byte[]> response = restTemplate.postForEntity(defaultUrlPrefix + path, entity, byte[].class);
        return convertResponse(response, clazz);
    }

    public void delete(String path) {
        delete(Void.class, path);
    }

    public <T> T delete(Class<T> clazz, String path) {
        ResponseEntity<byte[]> response = restTemplate.exchange(defaultUrlPrefix + path, DELETE, new HttpEntity<>(null), byte[].class);
        return convertResponse(response, clazz);
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    private <T> T convertResponse(ResponseEntity<byte[]> response, Class<T> clazz) {
        if (response.getStatusCode().series() != HttpStatus.Series.SUCCESSFUL) {
            throw new RuntimeException(String.valueOf(response));
        } else {
            return convertResponseBody(response.getBody(), clazz);
        }
    }

    private <T> T convertResponseBody(byte[] bytes, Class<T> clazz) {
        try {
            if (bytes == null) {
                return null;
            } else if (clazz == null || clazz.equals(Void.class)) {
                return null;
            }
            if (clazz.equals(byte[].class)) {
                return (T) bytes;
            } else {
                return objectMapper.readValue(bytes, clazz);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
