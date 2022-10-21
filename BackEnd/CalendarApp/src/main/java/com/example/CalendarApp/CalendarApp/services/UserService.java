package com.example.CalendarApp.CalendarApp.services;

import com.example.CalendarApp.CalendarApp.repositories.UserRepository;
import com.example.CalendarApp.CalendarApp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public User saveUser(String email){
        User newUser = new User(email);
        userRepository.save(newUser);
        return newUser;
    }
}
