package com.study.kotlin.cattastk.data.repositories

import androidx.lifecycle.LiveData
import com.study.kotlin.cattastk.data.database.dao.TaskDAO
import com.study.kotlin.cattastk.data.entity.Task
import com.study.kotlin.cattastk.domain.model.Date
import com.study.kotlin.cattastk.interfaces.TasksDAO
import com.study.kotlin.cattastk.interfaces.TasksRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class TaskRepository(private val DAO: TasksDAO): TasksRepository {

   override fun insert(task: Task) = runBlocking {
        launch (Dispatchers.IO){
            DAO.insert(task)
        }
    }

    override fun update(task: Task){
        DAO.update(task);
    }

    override fun select(task_id: Int): LiveData<Task> {
       return DAO.select(task_id)
    }

    override  fun getAll() = DAO.getAll()

    override fun getTodayTasks(selectedDate: Date): LiveData<List<Task>> {
        return DAO.getTodayTasks(selectedDate.toString())
    }

    override fun delete(task: Task) {
        return DAO.delete(task)
    }
}