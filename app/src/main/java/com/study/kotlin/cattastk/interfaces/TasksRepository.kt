package com.study.kotlin.cattastk.interfaces

import androidx.lifecycle.LiveData
import com.study.kotlin.cattastk.data.entity.Task
import com.study.kotlin.cattastk.domain.model.Date
import kotlinx.coroutines.Job

interface TasksRepository{

    fun insert(task: Task): Job

    fun update(task: Task): Job

    fun select(task_id:Int): LiveData<Task>

    fun getAll() : LiveData<List<Task>>

    fun getTodayTasks(selectedDate: Date): LiveData<List<Task>>

    fun delete(task: Task): Job
}