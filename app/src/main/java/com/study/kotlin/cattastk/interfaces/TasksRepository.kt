package com.study.kotlin.cattastk.interfaces

import androidx.lifecycle.LiveData
import com.study.kotlin.cattastk.data.entity.TaskEntity
import kotlinx.coroutines.Job

interface TasksRepository {

    fun insert(task: TaskEntity): Job

    fun getAll() : LiveData<List<TaskEntity>>

}