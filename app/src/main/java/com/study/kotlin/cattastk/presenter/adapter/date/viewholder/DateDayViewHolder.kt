package com.study.kotlin.cattastk.presenter.adapter.date.viewholder

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import com.study.kotlin.cattastk.databinding.DateDayBinding
import com.study.kotlin.cattastk.domain.model.Date


class DateDayViewHolder(
    private val binding: DateDayBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Date, isSelected:Boolean){

        if(isSelected) setDarkTheme() else setLightTheme()

        binding.dateTitle.text = item.getWeekBraziliamName()
        binding.dateDay.text = item.formatSimpleDate()
    }

    private fun setDarkTheme() {
        binding.dateDayBackground.setBackgroundColor(Color.BLACK)
        binding.dateDay.setTextColor(Color.WHITE)
        binding.dateTitle.setTextColor(Color.WHITE)
    }

    private fun setLightTheme() {
        binding.dateDayBackground.setBackgroundColor(Color.WHITE)
        binding.dateDay.setTextColor(Color.BLACK)
        binding.dateTitle.setTextColor(Color.BLACK)
    }
}