package com.study.kotlin.cattastk.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.study.kotlin.cattastk.data.entity.Task
import com.study.kotlin.cattastk.interfaces.TasksDAO

@Dao
interface TaskDAO: TasksDAO {

    @Query("SELECT * FROM Task")
    override fun getAll(): LiveData<List<Task>>

    @Query("SELECT * FROM Task WHERE id = :task_id")
    override fun select(task_id:Int): LiveData<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override suspend fun insert(task: Task)

    @Update
    override fun update(task: Task)
}