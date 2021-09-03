package com.study.kotlin.cattastk.domain.model

import java.util.*

class Date{

    companion object {

        fun isLeapYear(year: Int) = if (year%4 == 0) year%100 != 0 else year%400 == 0

        fun now():Date {

            val calendar = Calendar.getInstance()

            return Date(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
        }

        fun daysOfMonth(year: Int, month: Int) = when(month) {
            1 -> 31
            2 -> if(isLeapYear(year)) 29 else 28
            3 -> 31
            4 -> 30
            5 -> 31
            6 -> 30
            7 -> 31
            8 -> 31
            9 -> 30
            10 -> 31
            11 -> 30
            12 -> 31
            else -> -1
        }

    }

    var calendar = Calendar.getInstance()
    var year = calendar.get(Calendar.YEAR)
    var month = calendar.get(Calendar.MONTH)
    var day = calendar.get(Calendar.DAY_OF_MONTH)

    constructor( year: Int, month: Int, day: Int){ setDate(year,month,day) }

    constructor(date:String){

        val dates = date.split("/")

        setDate(dates[0].toInt(),dates[1].toInt(),dates[2].toInt())
    }

    private fun checkDay(day: Int): Int {
        return if (day in 0..31)
            day
        else
            1
    }

    private fun checkMonth(month: Int) = if (month in 1..12) month else 1


    fun setDate(year: Int, month: Int, day: Int){
        this.year = year
        this.month = checkMonth(month)
        this.day = checkDay(day)
        this.calendar.set(year,month,day)
    }

    fun isLeapYear() = if (year%4 == 0) year%100 != 0 else year%400 == 0

    fun getWeekBraziliamName() = when(calendar.get(Calendar.DAY_OF_WEEK)) {
            Calendar.SUNDAY -> "Domingo"
            Calendar.MONDAY -> "Segunda"
            Calendar.TUESDAY -> "Terça"
            Calendar.WEDNESDAY -> "Quarta"
            Calendar.THURSDAY -> "Quinta"
            Calendar.FRIDAY -> "Sexta"
            Calendar.SATURDAY -> "Sábado"
        else -> "Invalid Day"
    }

    fun getMonthBraziliamName() = when(month) {
        1 -> "janeiro"
        2 -> "Fevereiro"
        3 -> "Março"
        4 -> "Abril"
        5 -> "Maio"
        6 -> "Junho"
        7 -> "Julho"
        8 -> "Agosto"
        9 -> "Setembro"
        10 -> "Outubro"
        11 -> "Novembro"
        12 -> "Dezembro"
        else -> "Invalid Month"
    }


    fun daysOfMonth() = when(month) {
                1 -> 31
                2 -> if(isLeapYear()) 29 else 28
                3 -> 31
                4 -> 30
                5 -> 31
                6 -> 30
                7 -> 31
                8 -> 31
                9 -> 30
                10 -> 31
                11 -> 30
                12 -> 31
                else -> -1
            }

    override fun toString(): String {
        return "$day/$month/$year"
    }

/*
    constructor(
       date:String
        ): Times{

        SimpleDateFormat("dd/MM/yyyy").parse(string)

        super(Times(Date.from(Instant.now())))
    }
*/
}