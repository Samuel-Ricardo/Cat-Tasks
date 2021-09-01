package com.study.kotlin.cattastk.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.study.kotlin.cattastk.data.entity.TaskEntity

@Dao
interface TaskDAO {

    @Query("SELECT * FROM TaskEntity")
    fun getAll(): LiveData<List<TaskEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(taskEntity: TaskEntity)
}