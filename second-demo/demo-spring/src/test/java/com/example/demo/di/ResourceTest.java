package com.example.demo.di;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;

public class ResourceTest {

    @Test
    public void testResource() throws IOException {
        //Resource resource = new ClassPathResource("application.properties");

        Resource resource = new FileSystemResource("/home/libor/tmp.postman_environment.json");
        String text = FileCopyUtils.copyToString(new InputStreamReader(resource.getInputStream()));
        System.out.println(text);
    }

}
