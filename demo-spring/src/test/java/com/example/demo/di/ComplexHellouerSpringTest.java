package com.example.demo.di;

import com.example.di.AppConfiguration;
import com.example.di.ComplexHellouer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfiguration.class)
public class ComplexHellouerSpringTest {

    @Autowired
    ComplexHellouer hellouer;

    @Test
    public void testIt() {
        System.out.println(hellouer.complexHello());
    }

}
