package com.example.demo;

import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author Petr Janik 485122
 * @since 31/07/2019
 */
@RestController
public class MyController {
    private static final Logger LOG = LoggerFactory.getLogger(MyController.class);

    @GetMapping(value ="ping", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public MyPongResponse ping() {
        return new MyPongResponse("pong");
    }

    @PostMapping(path = "/members", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String addMemberV1(@RequestBody Member member) {
        return member.getName();
    }

    @RequestMapping(value = "/msg/delete", method = POST)
    public ResponseEntity deleteMessage(@RequestBody Map<String, String> message) {
        LOG.info("Delete message: {}", message);
//        String source = message.get("source").textValue();
//        LOG.info();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
