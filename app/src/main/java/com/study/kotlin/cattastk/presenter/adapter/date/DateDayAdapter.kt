package com.study.kotlin.cattastk.presenter.adapter.date

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.study.kotlin.cattastk.databinding.DateDayBinding
import com.study.kotlin.cattastk.presenter.adapter.date.viewholder.DateDayViewHolder
import com.study.kotlin.cattastk.presenter.adapter.task.viewholder.TaskViewHolder
import java.time.LocalDate
import java.util.*

class DateDayAdapter(
    val days: List<Date>,
    val onClick: (() -> Unit)
): RecyclerView.Adapter<DateDayViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateDayViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DateDayBinding.inflate(inflater, parent, false)

        return (DateDayViewHolder(binding))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: DateDayViewHolder, position: Int) {
        holder.bind(days[position])
    }

    override fun getItemCount(): Int = days.size
}