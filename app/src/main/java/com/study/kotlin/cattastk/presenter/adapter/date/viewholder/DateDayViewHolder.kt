package com.study.kotlin.cattastk.presenter.adapter.date.viewholder

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.study.kotlin.cattastk.databinding.ActivityAddTaskBinding
import com.study.kotlin.cattastk.databinding.DateDayBinding
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.*

class DateDayViewHolder(
    private val binding: DateDayBinding
): RecyclerView.ViewHolder(binding.root) {

    @RequiresApi(Build.VERSION_CODES.O)
    fun bind(item: LocalDate){
        binding.dateTitle.text = item.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("pt br"))
        binding.dateDay.text = "${item.dayOfMonth}/${item.month.value}"
    }
}