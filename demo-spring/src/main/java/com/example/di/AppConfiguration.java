package com.example.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackageClasses = AppConfiguration.class)
@PropertySource(value = "classpath:application.properties")
public class AppConfiguration {

    @Bean
    SimpleHellouer simpleHellouer() {
        return new SimpleHellouer("my text");
    }
}
