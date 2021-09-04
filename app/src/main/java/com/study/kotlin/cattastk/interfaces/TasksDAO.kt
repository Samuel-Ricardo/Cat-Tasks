package com.study.kotlin.cattastk.interfaces

import androidx.lifecycle.LiveData
import com.study.kotlin.cattastk.data.entity.Task

interface TasksDAO {

    fun select(task_id:Int): LiveData<List<Task>>

    fun getAll(): LiveData<List<Task>>

    fun getTodayTasks(): LiveData<List<Task>>

    suspend fun insert(task: Task)

    fun update(task: Task)
}