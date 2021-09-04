package com.study.kotlin.cattastk.presenter.adapter.date.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.study.kotlin.cattastk.databinding.DateDayBinding
import com.study.kotlin.cattastk.domain.model.Date


class DateDayViewHolder(
    private val binding: DateDayBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Date, isSelected:Boolean){

        binding.dateTitle.text = item.getWeekBraziliamName()
        binding.dateDay.text = item.formatSimpleDate()
    }
}