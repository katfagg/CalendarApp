package com.example.CalendarApp.CalendarApp.controllers;

import com.example.CalendarApp.CalendarApp.models.ToDoList;
import com.example.CalendarApp.CalendarApp.models.User;
import com.example.CalendarApp.CalendarApp.services.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/toDoLists")
public class ToDoListController {

    @Autowired
    ToDoListService toDoListService;

    @GetMapping(value = "/{email}")
    public ResponseEntity<ToDoList> getToDoListById(@PathVariable long email){
        Optional<ToDoList> toDoList = toDoListService.getToDoListById(email);
        if (toDoList.isPresent()){
            return  new ResponseEntity<>(toDoList.get(),HttpStatus.OK);
        } else {
            return  new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public ResponseEntity<ToDoList> startNewToDoList (@RequestParam long toDoListId){
        ToDoList savedToDoList = toDoListService.saveToDoList(toDoListId);
        return new ResponseEntity<>(savedToDoList, HttpStatus.CREATED);
    }

    //Delete list by id

}
