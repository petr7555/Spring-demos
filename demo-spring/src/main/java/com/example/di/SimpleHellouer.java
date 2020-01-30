package com.example.di;

import org.springframework.beans.factory.annotation.Value;


public class SimpleHellouer {

    private String text;

    public SimpleHellouer(@Value("${helloText}") String text) {
        this.text = text;
    }

    public String hello() {
        return text;
    }
}
