package com.example.demo;

import com.example.demo.entitites.PingLogEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PingLogRepository extends CrudRepository<PingLogEntity, Long> {

    @Query("select e from PingLogEntity e where e.text like concat(:prefix, '%')")
    List<PingLogEntity> getStartingWith(@Param("prefix") String prefix);

}
