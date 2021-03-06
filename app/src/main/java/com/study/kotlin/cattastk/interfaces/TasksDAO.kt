package com.study.kotlin.cattastk.interfaces

import androidx.lifecycle.LiveData
import com.study.kotlin.cattastk.data.entity.Task
import com.study.kotlin.cattastk.domain.model.Date

interface TasksDAO {

    fun select(task_id:Int): LiveData<Task>

    fun getAll(): LiveData<List<Task>>

    fun getTodayTasks(selectedDate: String): LiveData<List<Task>>

    suspend fun insert(task: Task)

    fun update(task: Task)

    fun delete(task: Task)
}