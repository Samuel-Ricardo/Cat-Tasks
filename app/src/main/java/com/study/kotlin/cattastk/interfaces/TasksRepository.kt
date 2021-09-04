package com.study.kotlin.cattastk.interfaces

import androidx.lifecycle.LiveData
import com.study.kotlin.cattastk.data.entity.Task
import kotlinx.coroutines.Job

interface TasksRepository{

    fun insert(task: Task): Job

    fun update(task: Task)

    fun select(task_id:Int): LiveData<List<Task>>

    fun getAll() : LiveData<List<Task>>

    fun getTodayTasks(): LiveData<List<Task>>

}