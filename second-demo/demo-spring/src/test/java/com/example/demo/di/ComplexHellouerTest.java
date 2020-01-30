package com.example.demo.di;

import com.example.di.ComplexHellouer;
import com.example.di.SimpleHellouer;
import org.junit.Test;
import org.mockito.Mockito;

public class ComplexHellouerTest {

    @Test
    public void testIt() {
        SimpleHellouer simpleHellouer = Mockito.mock(SimpleHellouer.class);
        Mockito.when(simpleHellouer.hello()).thenReturn("mocked hello");

        ComplexHellouer hellouer = new ComplexHellouer(simpleHellouer);
        System.out.println(hellouer.complexHello());
    }

}
