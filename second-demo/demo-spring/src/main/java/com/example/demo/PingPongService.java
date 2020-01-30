package com.example.demo;

import com.example.demo.entitites.MyPingRequest;
import com.example.demo.entitites.MyPongResponse;
import com.example.demo.entitites.PingLogEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class PingPongService {

    private PingLogRepository pingLogRepository;
    private UserRepository userRepository;

    public PingPongService(PingLogRepository pingLogRepository,
                           UserRepository userRepository) {
        this.pingLogRepository = pingLogRepository;
        this.userRepository = userRepository;
    }

    public MyPongResponse pingpong(MyPingRequest request) {
        for (int i = 1; i < 5; i++) {
            PingLogEntity entity = new PingLogEntity();
            entity.setText(request.getName() + i);
            entity.setCreatedBy(userRepository.findByName("jarda"));
            pingLogRepository.save(entity);
            if (request.getName().equals("error") && i == 3) {
                throw new RuntimeException("error");
            }
        }

        return new MyPongResponse(request.getName() + " from service");
    }

    @Transactional(readOnly = true)
    public Iterable<PingLogEntity> getLog() {
        return pingLogRepository.findAll();
    }

    public List<PingLogEntity> getLogStartingWith(String prefix) {
        return pingLogRepository.getStartingWith(prefix);
    }
}
