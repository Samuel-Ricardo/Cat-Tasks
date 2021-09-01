package com.study.kotlin.cattastk.interfaces

import androidx.lifecycle.LiveData
import com.study.kotlin.cattastk.data.entity.Task

interface TasksDAO {

    fun getAll(): LiveData<List<Task>>

    suspend fun insert(task: Task)
}