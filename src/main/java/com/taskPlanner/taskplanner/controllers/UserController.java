package com.taskPlanner.taskplanner.controllers;

import com.taskPlanner.taskplanner.model.User;
import com.taskPlanner.taskplanner.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl usi;

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(usi.getAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable String id) {
        return new ResponseEntity<>(usi.getById(id), HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User user){
        return new ResponseEntity<>(usi.create(user),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){
        return new ResponseEntity<>(usi.update(user),HttpStatus.ACCEPTED);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> removeUser(@PathVariable String id){
        usi.remove(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
