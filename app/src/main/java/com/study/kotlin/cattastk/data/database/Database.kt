package com.study.kotlin.cattastk.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.study.kotlin.cattastk.data.entity.TaskEntity

@Database(entities = [TaskEntity::class], version = 1)
abstract class DatabaseRoom: RoomDatabase() {

    abstract fun taskDAO(): TaskEntity

    companion object{

        @Volatile
        private var INSTANCE: DatabaseRoom? = null

        fun getDatabase(context: Context): DatabaseRoom {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseRoom::class.java,
                    "task_db"
                ).build();

                INSTANCE = instance

                instance
            }
        }
    }
}