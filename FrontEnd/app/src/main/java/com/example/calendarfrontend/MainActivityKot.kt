package com.example.calendarfrontend

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calendarfrontend.databinding.ToDoMainBinding

class MainActivityKot : AppCompatActivity(), TaskItemClickListener

{
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
                adapter = TaskItemAdapter(it, mainActivity)

            }
        }
    }

    override fun editTaskItem(taskItem: TaskItem) {
        NewTaskSheet(taskItem).show(supportFragmentManager,"newTaskTag")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun completeTaskItem(taskItem: TaskItem) {
        taskViewModel.setCompleted(taskItem)
    }
}

