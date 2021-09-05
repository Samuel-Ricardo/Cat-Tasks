package com.study.kotlin.cattastk.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.study.kotlin.cattastk.data.entity.Task
import com.study.kotlin.cattastk.domain.TaskUseCase
import com.study.kotlin.cattastk.domain.model.Date
import java.time.LocalDate

class MainViewModel (
    val taskUseCase: TaskUseCase
):ViewModel() {

    fun insert(task: Task): Boolean {
      return taskUseCase.insert(task)
    }

    fun getAll(): LiveData<List<Task>> {
        return taskUseCase.getAll()
    }

    fun getTodayTasks(selectedDate: Date): LiveData<List<Task>>{
        return taskUseCase.getTodayTasks(selectedDate)
    }

    fun update(task: Task): Boolean {
        return taskUseCase.update(task)
    }
}