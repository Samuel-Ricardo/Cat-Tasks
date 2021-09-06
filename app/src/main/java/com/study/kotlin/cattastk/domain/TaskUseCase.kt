package com.study.kotlin.cattastk.domain

import androidx.lifecycle.LiveData
import com.study.kotlin.cattastk.data.entity.Task
import com.study.kotlin.cattastk.data.repositories.TaskRepository
import com.study.kotlin.cattastk.domain.model.Date
import com.study.kotlin.cattastk.interfaces.TasksRepository

class TaskUseCase(
    private val repository: TasksRepository
) {

    fun insert(task: Task): Boolean {

        return try {
            repository.insert(task)
            true;
        }catch (ex: Exception){
            ex.printStackTrace();
            false;
        }
    }

    fun getAll(): LiveData<List<Task>> = repository.getAll()

    fun getTodayTasks(selectedDate: Date): LiveData<List<Task>> = repository.getTodayTasks(selectedDate);

    fun ifExistsDo(task: Task, action: ((Task) -> Unit)) = repository.select(task.id).observeForever{ action(it) }
/*
    //     val task = repository.select(task.id)

   //     return task.observeForever { task -> return@observeForever (task != null) as Unit; } as Boolean
  //  }
*/

    fun update(task: Task): Boolean {
        return try {
            repository.update(task)
            true;
        }catch (ex: Exception){
            ex.printStackTrace();
            false;
        }
    }

    fun delete(task: Task) {
        repository.delete(task)
    }

    fun select(task_id:Int) = repository.select(task_id)
}