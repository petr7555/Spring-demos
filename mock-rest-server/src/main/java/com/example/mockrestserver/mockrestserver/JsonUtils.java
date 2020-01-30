package com.example.mockrestserver.mockrestserver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

    public static String voAsString(Object vo) {
        try {
            return new ObjectMapper().writeValueAsString(vo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
