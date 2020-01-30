package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@Component
@ControllerAdvice(annotations = RestController.class)
public class MyExceptionHandler {

//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<String> exceptionHandler() {
//        return new ResponseEntity<>("chyba", HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
