package com.study.kotlin.cattastk.data.repositories

import com.study.kotlin.cattastk.data.entity.TaskEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class TaskRepository(private val DAO: TaskRepository) {

    fun insert(task: TaskEntity) = runBlocking {
        launch (Dispatchers.IO){
            DAO.insert(task)
        }
    }

    fun getAll() = DAO.getAll()
}