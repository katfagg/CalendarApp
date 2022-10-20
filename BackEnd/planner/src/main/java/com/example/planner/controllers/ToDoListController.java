package com.example.planner.controllers;

import com.example.planner.models.ToDoList;
import com.example.planner.models.Message;
import com.example.planner.services.ToDoListService;
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

    @GetMapping
    public ResponseEntity<List<ToDoList>> getAllToDoLists(){
        List<ToDoList> toDoLists;
        toDoLists = toDoListService.getToDoLists();
        return new ResponseEntity<>(toDoLists, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ToDoList> getToDoListById(@PathVariable long id){
        Optional<ToDoList> toDoList = toDoListService.getToDoListById(id);
        if (toDoList.isPresent()){
            return  new ResponseEntity<>(toDoList.get(),HttpStatus.OK);
        } else {
            return  new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public ResponseEntity<Message> startNewToDoList (@RequestParam long toDoListId){
        Message message = toDoListService.startNewToDoList(toDoListId);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    //Patch request to update list
    //Delete list by id

}
