package com.example.demo;

import com.example.demo.entitites.UserEntity;
import com.example.demo.my.Person;
import com.example.demo.my.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableTransactionManagement
public class DemoApplication {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @PostConstruct
    public void init() {
        UserEntity user = new UserEntity();
        user.setName("jarda");
        userRepository.save(user);

        personRepository.save(new Person("Petr"));
    }
}
