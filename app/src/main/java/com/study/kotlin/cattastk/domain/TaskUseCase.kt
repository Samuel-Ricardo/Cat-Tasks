package com.study.kotlin.cattastk.domain

import androidx.lifecycle.LiveData
import com.study.kotlin.cattastk.data.entity.Task
import com.study.kotlin.cattastk.data.repositories.TaskRepository
import com.study.kotlin.cattastk.interfaces.TasksRepository

class TaskUseCase(
    private val repository: TasksRepository
) {

    fun insert(task: Task) {
        repository.insert(task)
    }

    fun getAll(): LiveData<List<Task>> {
        return repository.getAll()
    }

    fun exists(task: Task):Boolean {

        val task = repository.select(task.id)

        return task.size > 0;

    }
}