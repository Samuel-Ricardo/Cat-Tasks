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
        var days = MutableLiveData<List<Date>>()
    }

    override fun onCreate() {
        super.onCreate()

        setupAppCalendar()
    }

    private fun setupAppCalendar() {
        val now = Date.now();

        var dates = mutableListOf<Date>()

        var month = 1
        var dayOfMotnh = 1

        while (month <=  12){
            while(dayOfMotnh <= Date.daysOfMonth(month, now.year)){
                dates.add(Date(
                    now.year,
                    month,
                    dayOfMotnh
                ))
                dayOfMotnh ++
            }
            dayOfMotnh = 1
            month ++
        }

        days.value = dates;
    }


}