package com.study.kotlin.cattastk.domain.model

import android.system.Os
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.Instant
import kotlin.properties.Delegates


class Date{

    var year = 2021
    var month = 9
    var day = 2

    constructor(
        year: Int,
        month: Int,
        day: Int,
    ){

        this.year = year
        this.month = month
        this.day = checkDay(day)
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