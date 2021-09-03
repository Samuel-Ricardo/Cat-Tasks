package com.study.kotlin.cattastk.domain.model

class Time {

    var hour = 0
    var minutes = 0

     fun setTime(hour: Int, minutes: Int){
        this.hour = checkHour(hour)
        this.minutes = checkMinutes(minutes)
    }

    private fun checkHour(hour: Int): Int {
        return if (hour in 1..24) hour else 0
    }


}