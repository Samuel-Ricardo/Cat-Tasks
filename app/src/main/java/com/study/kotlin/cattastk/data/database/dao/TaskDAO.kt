package com.study.kotlin.cattastk.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.study.kotlin.cattastk.data.entity.TaskEntity
import com.study.kotlin.cattastk.interfaces.TasksDAO

@Dao
interface TaskDAO: TasksDAO {

    @Query("SELECT * FROM TaskEntity")
    override fun getAll(): LiveData<List<TaskEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override suspend fun insert(taskEntity: TaskEntity)
}