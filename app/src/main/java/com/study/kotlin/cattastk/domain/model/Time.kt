package com.study.kotlin.cattastk.domain.model

class Time {

    var hour = 0
    var minutes = 0

    constructor(hour: Int, minutes: Int) { setTime(hour, minutes) }

    constructor(time:String) {
        val times = time.split(":")
        setTime(times[0].toInt(),times[1].toInt())
    }

     fun setTime(hour: Int, minutes: Int){
        this.hour = checkHour(hour)
        this.minutes = checkMinutes(minutes)
    }

    private fun checkMinutes(minutes: Int): Int {
        return if (hour in 0..60) hour else 0
    }

    private fun checkHour(hour: Int): Int {
        return if (hour in 1..24) hour else 0
    }


}