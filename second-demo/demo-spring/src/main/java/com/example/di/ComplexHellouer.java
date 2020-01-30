package com.example.di;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Random;

@Component
public class ComplexHellouer {

    private SimpleHellouer simpleHellouer;
    private int id = new Random().nextInt();

    public  ComplexHellouer(SimpleHellouer simpleHellouer) {
        this.simpleHellouer = simpleHellouer;
    }

    public String complexHello() {
        return "complex " + simpleHellouer.hello() + "id " + id;
    }

    @PostConstruct
    public void init() {
        System.out.println("Initialiazed with id " + id);
    }

    @PreDestroy
    public void free() {
        System.out.println("Freeing resources");
    }

}
