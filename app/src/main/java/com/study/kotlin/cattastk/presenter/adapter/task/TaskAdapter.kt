package com.study.kotlin.cattastk.presenter.adapter.task

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.study.kotlin.cattastk.data.entity.Task
import com.study.kotlin.cattastk.databinding.TaskLayoutBinding
import com.study.kotlin.cattastk.presenter.adapter.task.diff.DiffCallback
import com.study.kotlin.cattastk.presenter.adapter.task.viewholder.TaskViewHolder
import java.time.LocalDate

class TaskAdapter(val selectedDay:LocalDate): ListAdapter<Task,TaskViewHolder>(DiffCallback()) {

    var listenerEdit: (Task) -> Unit = {}
    var listenerDelete: (Task) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TaskLayoutBinding.inflate(inflater, parent, false)

        return TaskViewHolder(binding);
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val item = getItem(position)
        val date = item.date.split("/")
        val itemDate = LocalDate.of(date[0].toInt(), date[1].toInt(), date[2].toInt())

        if(
            selectedDay.monthValue == itemDate.monthValue
            &&
            selectedDay.dayOfMonth == itemDate.dayOfMonth
        ){
          //  holder.bind(item)
        }

        holder.bind(item)
    }
}