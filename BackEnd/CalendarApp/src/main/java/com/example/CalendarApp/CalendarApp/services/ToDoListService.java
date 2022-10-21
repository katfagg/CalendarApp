package com.example.CalendarApp.CalendarApp.services;

import com.example.CalendarApp.CalendarApp.models.*;
import com.example.CalendarApp.CalendarApp.repositories.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoListService {

    @Autowired
    UserService userService;

    @Autowired
    ToDoListRepository toDoListRepository;

    public List<ToDoList> getToDoLists(){
        return toDoListRepository.findAll();
    }

    public Message startNewToDoList(long userId){
        User user = userService.getUserById(userId).get();
        ToDoList toDoList = new ToDoList(user);

        toDoListRepository.save(toDoList);
        return new Message(String.format("Have you completed the task ", toDoList.getUser().getEmail(), "?"));
    }

    public Optional<ToDoList> getToDoListById(Long id){
        return toDoListRepository.findById(id);
    }

}
