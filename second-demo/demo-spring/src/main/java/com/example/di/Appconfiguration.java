package com.example.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackageClasses = Appconfiguration.class)
@PropertySource(value = "classpath:application.properties")
public class Appconfiguration {

    @Bean
    SimpleHellouer simpleHellouer() {
        return new SimpleHellouer("my text");
    }

}
