package com.example.demo.my;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Petr Janik 485122
 * @since 13/08/2019
 */
//TODO try integer as ID
public interface PersonRepository extends CrudRepository<Person, Long> {
    //automatically takes "name" field
    Person findByName(String make);
}
