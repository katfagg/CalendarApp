package com.example.calendarfrontend

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.calendarfrontend.databinding.ActivityMainBinding
import com.example.calendarfrontend.databinding.ToDoMainBinding

class MainActivityKot : AppCompatActivity() {
        private lateinit var binding: ToDoMainBinding
        private lateinit var taskViewModel: TaskViewModel

        override fun onCreate(savedInstanceState: Bundle?)
        {
            super.onCreate(savedInstanceState)
            binding = ToDoMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
            binding.newTaskButton.setOnClickListener {
                NewTaskSheet().show(supportFragmentManager, "newTaskTag")
            }

            taskViewModel.name.observe(this){
                binding.taskName.text = String.format("Task Name: %s", it)
            }
            taskViewModel.desc.observe(this){
                binding.taskDescription.text = String.format("Task Description: %s", it)
            }


        }
    }

