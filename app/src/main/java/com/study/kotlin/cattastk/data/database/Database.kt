package com.study.kotlin.cattastk.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.study.kotlin.cattastk.data.database.dao.TaskDAO
import com.study.kotlin.cattastk.data.entity.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun taskDAO(): TaskDAO

    companion object{

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "task_db"
                ).build();

                INSTANCE = instance

                instance
            }
        }
    }
}