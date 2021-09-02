package com.study.kotlin.cattastk.presenter.adapter.date

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.ListAdapter
import com.study.kotlin.cattastk.databinding.DateDayBinding
import com.study.kotlin.cattastk.presenter.adapter.date.viewholder.DateDayViewHolder
import com.study.kotlin.cattastk.presenter.adapter.task.viewholder.TaskViewHolder
import java.time.LocalDate

class DateDayAdapter: ListAdapter<LocalDate, DateDayViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateDayViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DateDayBinding.inflate(inflater, parent, false)

        return (DateDayViewHolder(binding))
    }

    override fun onBindViewHolder(holder: DateDayViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}