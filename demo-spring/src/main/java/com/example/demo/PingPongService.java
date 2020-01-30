package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class PingPongService {

    public MyPongResponse pingPong(MyPingRequest request) {
        return new MyPongResponse(request.getName() + " from service");
    }

}
