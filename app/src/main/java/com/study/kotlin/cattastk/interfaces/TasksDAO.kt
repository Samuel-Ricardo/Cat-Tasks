package com.study.kotlin.cattastk.interfaces

import androidx.lifecycle.LiveData
import com.study.kotlin.cattastk.data.entity.TaskEntity

interface TasksDAO {

    fun getAll(): LiveData<List<TaskEntity>>

    suspend fun insert(taskEntity: TaskEntity)
}