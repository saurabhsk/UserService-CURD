package com.stackroute.userservice.controllers;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;


import java.util.List;

@RestController
@RequestMapping("api/v1")
@Slf4j
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/user")
    public ResponseEntity<User>saveUser(@RequestBody User user){
          User savedUser = userService.saveUser(user);
          return new ResponseEntity<User>(savedUser, HttpStatus.OK);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User>updateUser(@RequestBody User user,@PathVariable int id){
        user.setId(id);
        User updateUser = userService.updateUser(user);
        return  new ResponseEntity<User>(updateUser,HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allusers = userService.getAllUsers();
        log.debug("This is a debug message");
        log.info("This is an info message");
        log.warn("This is a warn message");
        log.error("This is an error message");
        return new ResponseEntity<>(allusers,HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User>getUserById(@PathVariable int id){
        User userById = userService.getUserById(id);
        return new ResponseEntity<User>(userById,HttpStatus.OK);
    }
    @GetMapping("/userse/{id}")

    public void removeTrack(@PathVariable int id) {
        userService.removeById(id);

    }
}
