package com.example.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);

        ComplexHellouer hellouer = ctx.getBean(ComplexHellouer.class);
        ComplexHellouer hellouer2 = ctx.getBean(ComplexHellouer.class);

        System.out.println(hellouer.complexHello());
        System.out.println(hellouer2.complexHello());
    }

}
