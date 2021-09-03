package com.study.kotlin.cattastk

import android.app.Application
import android.icu.util.Calendar
import androidx.lifecycle.MutableLiveData
import com.study.kotlin.cattastk.data.database.AppDatabase
import com.study.kotlin.cattastk.data.repositories.TaskRepository
import com.study.kotlin.cattastk.domain.TaskUseCase
import com.study.kotlin.cattastk.domain.model.Date
import java.time.LocalDate

class App: Application() {

    val database by lazy {AppDatabase.getDatabase(this)}
    val repository by lazy {TaskRepository(database.taskDAO())}
    val taskUseCase by lazy {TaskUseCase(repository)}

    companion object{
        var days = MutableLiveData<List<LocalDate>>()
    }

    override fun onCreate() {
        super.onCreate()

        val now = Date.now();

        var daysInMonth = mutableListOf<Date>()

        var cont = 1

        while (cont <=  now.daysOfMonth()){
            daysInMonth.add(now.withDayOfMonth(cont))
        }

        days.value = daysInMonth;
    }
}