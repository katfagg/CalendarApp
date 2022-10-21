package com.example.CalendarApp.CalendarApp.DataLoader;

import com.example.CalendarApp.CalendarApp.repositories.ToDoListRepository;
import com.example.CalendarApp.CalendarApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ToDoListRepository toDoListRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //add set values
    }
}

