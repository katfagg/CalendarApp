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

    public Optional<ToDoList> getToDoListById(Long id){
        return toDoListRepository.findById(id);
    }

    public ToDoList saveToDoList(UserService userService){
        ToDoList newToDoList = new ToDoList(userService);
        toDoListRepository.save(newToDoList);
        return newToDoList;
    }

}
