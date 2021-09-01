package com.study.kotlin.cattastk.data.repositories

import androidx.lifecycle.LiveData
import com.study.kotlin.cattastk.data.database.dao.TaskDAO
import com.study.kotlin.cattastk.data.entity.Task
import com.study.kotlin.cattastk.interfaces.TasksRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class TaskRepository(private val DAO: TaskDAO): TasksRepository {

   override fun insert(task: Task) = runBlocking {
        launch (Dispatchers.IO){
            DAO.insert(task)
        }
    }

    override fun select(task_id: Int): LiveData<List<Task>> {
       return DAO.select(task_id)
    }

    override  fun getAll() = DAO.getAll()
}