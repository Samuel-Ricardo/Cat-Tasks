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

            if(exists(task)){
                repository.update(task)
            }else{
                repository.insert(task)
            }

            true;
        }catch (ex: Exception){
            ex.printStackTrace();
            false;
        }
    }

    fun getAll(): LiveData<List<Task>> {
        return repository.getAll()
    }

    fun getTodayTasks(selectedDate: Date): LiveData<List<Task>> {
        return repository.getTodayTasks(selectedDate);
    }

    fun exists(task: Task):Boolean {

        val task = repository.select(task.id)

        val value = task.value

        return task.value != null;
    }

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
}