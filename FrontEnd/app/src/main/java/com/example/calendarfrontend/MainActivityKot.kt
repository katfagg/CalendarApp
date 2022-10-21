package com.example.calendarfrontend

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
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
                NewTaskSheet(null).show(supportFragmentManager, "newTaskTag")
            }
            setRecyclerView()
        }

    private fun setRecyclerView() {
        val mainActivity = this
        taskViewModel.taskItems.observe(this){
            binding.todoListRecyclerView.apply {
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = TaskItemAdapter(it)

            }
        }
    }
}

