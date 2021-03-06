package com.study.kotlin.cattastk.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.study.kotlin.cattastk.data.entity.Task
import com.study.kotlin.cattastk.domain.model.Date
import com.study.kotlin.cattastk.interfaces.TasksDAO

@Dao
interface TaskDAO: TasksDAO {

    @Query("SELECT * FROM Task")
    override fun getAll(): LiveData<List<Task>>

    @Query("SELECT * FROM Task WHERE date = :selectedDate")
    override fun getTodayTasks(selectedDate: String): LiveData<List<Task>>

    @Query("SELECT * FROM Task WHERE id = :task_id")
    override fun select(task_id:Int): LiveData<Task>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override suspend fun insert(task: Task)

    @Update(onConflict = OnConflictStrategy.REPLACE , entity = Task::class)
    override fun update(task: Task)

    @Delete(entity = Task::class)
    override fun delete(task: Task)
}