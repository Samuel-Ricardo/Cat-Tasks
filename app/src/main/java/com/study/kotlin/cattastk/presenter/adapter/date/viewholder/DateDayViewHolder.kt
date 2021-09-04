package com.study.kotlin.cattastk.presenter.adapter.date.viewholder

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import com.study.kotlin.cattastk.R
import com.study.kotlin.cattastk.databinding.DateDayBinding
import com.study.kotlin.cattastk.domain.model.Date


class DateDayViewHolder(
    private val binding: DateDayBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Date, position:Int, isSelected: Boolean, onClick: (Date, Int) -> Unit){

        if(isSelected) setDarkTheme() else setLightTheme()

        binding.lblDateTitle.text = item.getWeekBraziliamName()
        binding.lblDateDay.text = item.formatSimpleDate()

        itemView.setOnClickListener {
            it.isSelected = !it.isSelected

            if(it.isSelected){

            }

            this@DateDayViewHolder.bind(item, position, it.isSelected, onClick)

            onClick(item,position)
        }
    }

    private fun setDarkTheme() {
        binding.dateDayBackground.setBackgroundColor(Color.BLACK)
        binding.lblDateDay.setTextColor(Color.WHITE)
        binding.lblDateTitle.setTextColor(Color.WHITE)


    }

    private fun setLightTheme() {
        binding.dateDayBackground.setBackgroundResource(R.drawable.border_black)
        binding.lblDateDay.setTextColor(Color.BLACK)
        binding.lblDateTitle.setTextColor(Color.BLACK)
    }
}