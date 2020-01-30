package com.example.demo;

import com.example.demo.entitites.MyPingRequest;
import com.example.demo.entitites.MyPongResponse;
import com.example.demo.entitites.PingLogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.*;

@RestController
public class MyController {

    private PingPongService service;

    @Autowired
    public MyController(PingPongService service) {
        this.service = service;
    }

    @GetMapping(value = "ping", produces = APPLICATION_JSON_UTF8_VALUE)
    public MyPongResponse ping() {
        return new MyPongResponse("pong");
    }

    @GetMapping(value = "ping/{name}")
    public MyPongResponse pingWithName(@PathVariable("name") String name) {
        return service.pingpong(new MyPingRequest(name));
    }

    @PostMapping(value = "ping", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public MyPongResponse postPing(@RequestBody MyPingRequest request) {
        return service.pingpong(request);
    }

    @GetMapping("log")
    public Iterable<PingLogEntity> getLog() {
        return service.getLog();
    }

    @GetMapping("log/{prefix}")
    public Iterable<PingLogEntity> getLogWithPrefix(@PathVariable("prefix") String prefix) {
        return service.getLogStartingWith(prefix);
    }
}
