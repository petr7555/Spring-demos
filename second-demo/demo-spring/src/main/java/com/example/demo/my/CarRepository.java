package com.example.demo.my;

import com.example.demo.entitites.PingLogEntity;
import com.example.demo.entitites.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Petr Janik 485122
 * @since 13/08/2019
 */
public interface CarRepository extends CrudRepository<Car, Long> {
    Car findByMake(String make);

    @Query("select e from Car e where e.make like concat(:prefix, '%')")
    List<Car> getStartingWith(@Param("prefix") String prefix);
}
