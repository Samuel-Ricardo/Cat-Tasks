package com.study.kotlin.cattastk

import android.app.Application
import android.icu.util.Calendar
import androidx.lifecycle.MutableLiveData
import com.study.kotlin.cattastk.data.database.AppDatabase
import com.study.kotlin.cattastk.data.repositories.TaskRepository
import com.study.kotlin.cattastk.domain.TaskUseCase
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

        val now = LocalDate.now()

        var daysInMonth = mutableListOf<LocalDate>()

        var cont = 1

        while (cont <=  now.month.length()){
            daysInMonth.add(now.withDayOfMonth(cont))
        }

        days.value = daysInMonth;
    }
}