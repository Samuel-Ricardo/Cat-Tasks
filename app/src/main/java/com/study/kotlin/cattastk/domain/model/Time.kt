package com.study.kotlin.cattastk.domain.model

class Time {

    var hour = 0
    var minutes = 0

    private fun setData(hour: Int, minutes: Int){
        this.hour = checkHour(hour)
        this.minutes = checkMinutes(minutes)
    }
}