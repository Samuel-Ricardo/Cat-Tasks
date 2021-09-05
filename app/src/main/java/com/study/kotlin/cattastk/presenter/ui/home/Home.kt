package com.study.kotlin.cattastk.presenter.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.study.kotlin.cattastk.App
import com.study.kotlin.cattastk.data.entity.Task
import com.study.kotlin.cattastk.databinding.ActivityHomeBinding
import com.study.kotlin.cattastk.domain.TaskUseCase
import com.study.kotlin.cattastk.domain.model.Date
import com.study.kotlin.cattastk.presenter.adapter.date.DateDayAdapter
import com.study.kotlin.cattastk.presenter.adapter.task.TaskAdapter
import com.study.kotlin.cattastk.presenter.ui.task.create.AddTaskActivity
import com.study.kotlin.cattastk.presenter.viewmodel.MainViewModel
import com.study.kotlin.cattastk.presenter.viewmodel.factory.MainViewModelFactory
import com.study.kotlin.cattastk.util.text

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
    val taskAdapter by lazy {TaskAdapter(Date.now()) {task -> setupNotesEditor(task)}}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setup()
    }

    private fun setup() {
        binding.notesEditor.notesEditor.visibility = View.GONE
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
        binding.rcvDays.layoutManager!!.scrollToPosition(Date.now().dayOfYear()-31)
    }

    private fun setupTasksList(selectedDate: Date) {
        binding.rcvTasksList.adapter = this.taskAdapter;
        updateTaskList(selectedDate);
    }

    private fun setupNotesEditor(task: Task) {
        binding.notesEditor.notesEditor.visibility = View.VISIBLE

        binding.notesEditor.titleUpdate.text = task.title
        binding.notesEditor.notesUpdate.text = task.notes

        binding.notesEditor.imgCloseUpdateNotes.setOnClickListener { binding.notesEditor.notesEditor.visibility = View.GONE }
        binding.notesEditor.btnUpdateNotes.setOnClickListener {

            task.title = binding.notesEditor.titleUpdate.text
            task.notes = binding.notesEditor.notesUpdate.text

            if (viewModel.insert(task)){
                Toast.makeText(
                    this,
                    "Alterações salvas com sucesso",
                    Toast.LENGTH_LONG
                )
                binding.notesEditor.notesEditor.visibility = View.GONE
            }else{
                Toast.makeText(
                    this,
                    "Não foi possivel salvar as alterações",
                    Toast.LENGTH_LONG
                )
            }
        }
    }


    private fun updateTaskList(selectedDate: Date) {

        val allTasks = viewModel.getAll();

        viewModel.getTodayTasks(selectedDate).observe(this, {tasks ->
             if(tasks.isEmpty()){
                 binding.emptyState.emptyState.visibility = View.VISIBLE
                 binding.rcvTasksList.visibility = View.GONE
            } else{
                 binding.emptyState.emptyState.visibility = View.GONE
                 binding.rcvTasksList.visibility = View.VISIBLE
             }
            taskAdapter.updateList(tasks, selectedDate)
        })
    }
}
