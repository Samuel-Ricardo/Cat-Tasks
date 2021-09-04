package com.study.kotlin.cattastk

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.study.kotlin.cattastk.data.database.AppDatabase
import com.study.kotlin.cattastk.data.repositories.TaskRepository
import com.study.kotlin.cattastk.domain.TaskUseCase
import com.study.kotlin.cattastk.domain.model.Date

class App: Application() {

    val database by lazy {AppDatabase.getDatabase(this)}
    val repository by lazy {TaskRepository(database.taskDAO())}
    val taskUseCase by lazy {TaskUseCase(repository)}

    companion object{
        var daysOfYear = MutableLiveData<List<Date>>()
    }

    override fun onCreate() {
        setupAppCalendar()
        super.onCreate()
    }

    private fun setupAppCalendar() {
        val now = Date.now();

        var dates = mutableListOf<Date>()

        var month = 1
        var dayOfMotnh = 1

        while (month !=  12){
            while(dayOfMotnh != Date.daysOfMonth(now.year, month)){
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
        dayOfMotnh = 1
        month = 1

        daysOfYear.value = dates;
    }
}