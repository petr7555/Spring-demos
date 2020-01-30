package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

//@RestController
@RestController
public class MyController {

//    private PingPongService service;
//
//    @Autowired
//    public MyController(PingPongService service) {
//        this.service = service;
//    }
//
//    @GetMapping(value = "ping", produces = APPLICATION_JSON_UTF8_VALUE)
//    public MyPongResponse ping() {
//        return new MyPongResponse("pong");
//    }
//
//    @GetMapping(value = "ping/{name}")
//    public MyPongResponse pingWithName(@PathVariable("name") String name) {
//        return new MyPongResponse("hello " + name);
//    }
//
//    @PostMapping(value = "ping", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
//    public MyPongResponse postPing(@RequestBody MyPingRequest request) {
//        return service.pingPong(request);
//    }

//    @Autowired
//    private IPostService postService;
//
//    @GetMapping(value = "/posts")
//    public ResponseEntity<Set<Post>> all() {
//        return ok().body(postService.all());
//    }
//
//    @DeleteMapping(value = "/posts/{id}")
//    public ResponseEntity<Long> deletePost(@PathVariable Long id) {
//
//        boolean isRemoved = postService.delete(id);
//
//        if (!isRemoved) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        return new ResponseEntity<>(id, HttpStatus.OK);
//    }

    @Autowired
    UserService userService;

    @GetMapping(value = "/users")
    public ResponseEntity<Map<Long, UserDto>> all() {
        return ok().body(userService.all());
    }

    @PutMapping(value = "/users/{userId}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserDto> updateUser(@PathVariable long userId, @RequestBody UserDto requestUserDetails) {
        UserDto userDto = null;
        try {
            userDto = userService.updateUser(requestUserDetails, userId);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
