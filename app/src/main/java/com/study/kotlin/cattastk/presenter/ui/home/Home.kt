package com.study.kotlin.cattastk.presenter.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.study.kotlin.cattastk.App
import com.study.kotlin.cattastk.databinding.ActivityHomeBinding
import com.study.kotlin.cattastk.domain.TaskUseCase
import com.study.kotlin.cattastk.domain.model.Date
import com.study.kotlin.cattastk.presenter.adapter.date.DateDayAdapter
import com.study.kotlin.cattastk.presenter.adapter.task.TaskAdapter
import com.study.kotlin.cattastk.presenter.ui.task.create.AddTaskActivity
import com.study.kotlin.cattastk.presenter.viewmodel.MainViewModel
import com.study.kotlin.cattastk.presenter.viewmodel.factory.MainViewModelFactory

class Home : AppCompatActivity() {

    companion object {
        private const val CREATE_NEW_TASK = 1000
    }

    val binding by lazy {ActivityHomeBinding.inflate(layoutInflater)}
    val viewModel by viewModels<MainViewModel> {
        MainViewModelFactory(
            TaskUseCase((application as App).repository)
        )
    }
    val taskAdapter by lazy {TaskAdapter(Date.now())}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setup()
    }

    private fun setup() {
        setupLists();
        setupListeners()
    }

    private fun setupListeners() {
        binding.btnAddTask.setOnClickListener {
            startActivity(Intent(this,  AddTaskActivity::class.java))
        }
    }

    private fun setupLists() {
        setupDaysList()
        setupTasksList(Date.now())
    }

    private fun setupDaysList() {

        var adapter =  DateDayAdapter(App.daysOfYear.value ?: listOf(Date.now())) { item, position ->
            this@Home.updateTaskList(item);
            binding.rcvDays.layoutManager?.scrollToPosition(position)
        }

        binding.rcvDays.adapter = adapter
        binding.rcvDays.layoutManager!!.scrollToPosition(Date.now().dayOfYear()-1)
    }

    private fun setupTasksList(selectedDate: Date) {
        binding.rcvTasksList.adapter = this.taskAdapter;
        updateTaskList(selectedDate);
    }

    private fun updateTaskList(selectedDate: Date) {

        val allTasks = viewModel.getAll();

        viewModel.getTodayTasks(selectedDate).observe(this, {tasks ->
            binding.emptyState.emptyState.visibility = if(tasks.isEmpty()) View.VISIBLE else View.GONE
            taskAdapter.updateList(tasks, selectedDate)
        })
    }
}
