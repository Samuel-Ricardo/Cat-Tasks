package com.study.kotlin.cattastk.domain.model

import androidx.lifecycle.LiveData
import com.study.kotlin.cattastk.data.entity.Task
import com.study.kotlin.cattastk.data.repositories.TaskRepository

class TaskUseCase(
    private val taskRepository: TaskRepository
) {

    fun insert(task: Task) {
        taskRepository.insert(task)
    }

    fun getAll(): LiveData<List<Task>> {
        return taskRepository.getAll()
    }


}