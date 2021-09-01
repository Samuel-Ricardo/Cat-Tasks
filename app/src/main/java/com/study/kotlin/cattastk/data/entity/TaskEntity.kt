package com.study.kotlin.cattastk.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalTime

@Entity
data class TaskEntity (
    @PrimaryKey(autoGenerate = true) val id:Int = 0,
    val title:String,
    val notes:String,
    val date:LocalDate,
    val time:LocalTime,
)