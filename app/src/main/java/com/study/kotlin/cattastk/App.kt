package com.study.kotlin.cattastk

import android.app.Application
import com.study.kotlin.cattastk.data.database.AppDatabase
import com.study.kotlin.cattastk.data.repositories.TaskRepository

class App: Application() {

    val database by lazy {AppDatabase.getDatabase(this)}
    val repository by lazy {TaskRepository(database.taskDAO())}
}