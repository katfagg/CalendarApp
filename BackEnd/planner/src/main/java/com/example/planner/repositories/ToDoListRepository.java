package com.example.planner.repositories;

import com.example.planner.models.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepository extends JpaRepository <ToDoList, Long> {
}
