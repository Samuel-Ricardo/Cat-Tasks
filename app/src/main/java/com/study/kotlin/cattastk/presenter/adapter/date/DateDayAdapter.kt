package com.study.kotlin.cattastk.presenter.adapter.date

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.study.kotlin.cattastk.databinding.DateDayBinding
import com.study.kotlin.cattastk.domain.model.Date
import com.study.kotlin.cattastk.presenter.adapter.date.viewholder.DateDayViewHolder
import com.study.kotlin.cattastk.presenter.adapter.task.viewholder.TaskViewHolder

class DateDayAdapter(
    val days: List<Date>,
    val onClick: (() -> Unit)
): RecyclerView.Adapter<DateDayViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateDayViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DateDayBinding.inflate(inflater, parent, false)

        return (DateDayViewHolder(binding))
    }

    override fun onBindViewHolder(holder: DateDayViewHolder, position: Int) {

        val now = Date.now()

        if(now.isEquals(days[position])){

            holder.bind(days[position], true)
            holder.itemView.isSelected = true
        }else{
            holder.bind(days[position], false)
        }



    }

    override fun getItemCount(): Int = days.size
}