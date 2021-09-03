package com.study.kotlin.cattastk.domain.model

class Date{

    var year = 2021
    var month = 9
    var day = 2

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
    }

    override fun toString(): String {
        return "$day/$month/$year"
    }

    fun getMonthBraziliamName():String {

        when(month) {
            1 -> "janeiro"
        }
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