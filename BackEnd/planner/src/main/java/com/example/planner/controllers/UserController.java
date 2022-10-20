package com.example.planner.controllers;

import com.example.planner.models.User;
import com.example.planner.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //Might need to change this from id to email
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()){
            return new ResponseEntity<>(user.get(),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<User> addNewUser(@RequestParam String email){
        User savedUser = userService.saveUser(email);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }

    //Delete User by id or email

}
