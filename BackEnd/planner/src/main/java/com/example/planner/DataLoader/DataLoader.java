package com.example.planner.DataLoader;

import com.example.planner.repositories.ToDoListRepository;
import com.example.planner.repositories.UserRepository;
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
