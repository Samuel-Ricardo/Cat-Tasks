package com.study.kotlin.cattastk.presenter.adapter.date.viewholder

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.study.kotlin.cattastk.databinding.ActivityAddTaskBinding
import com.study.kotlin.cattastk.databinding.DateDayBinding
import com.study.kotlin.cattastk.domain.model.Date
import java.time.format.TextStyle


class DateDayViewHolder(
    private val binding: DateDayBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Date, isSelected:Boolean){

        binding.dateTitle.text = item.getWeekBraziliamName()
        binding.dateDay.text = "${item.day}/${item.month}"
    }
}