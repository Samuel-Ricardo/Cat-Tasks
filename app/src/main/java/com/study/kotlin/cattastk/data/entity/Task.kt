package com.study.kotlin.cattastk.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalTime

@Entity
data class Task (
    @PrimaryKey(autoGenerate = true) val id:Int = 0,
    var title:String,
    var notes:String,
    var date:String,
    var time:String,
)