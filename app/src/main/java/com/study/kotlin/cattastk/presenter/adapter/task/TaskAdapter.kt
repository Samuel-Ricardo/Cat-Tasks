package com.study.kotlin.cattastk.presenter.adapter.task

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.study.kotlin.cattastk.data.entity.Task
import com.study.kotlin.cattastk.databinding.TaskLayoutBinding
import com.study.kotlin.cattastk.domain.model.Date
import com.study.kotlin.cattastk.presenter.adapter.task.diff.DiffCallback
import com.study.kotlin.cattastk.presenter.adapter.task.viewholder.TaskViewHolder

class TaskAdapter(
    var selectedDay:Date,
    var onClick: (Task) -> Unit
): ListAdapter<Task,TaskViewHolder>(DiffCallback()) {

    var listenerEdit: (Task) -> Unit = {}
    var listenerDelete: (Task) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TaskLayoutBinding.inflate(inflater, parent, false)

        return TaskViewHolder(binding);
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {

        holder.bind(getItem(position), onClick)
    }

    fun updateList(list: List<Task>, selectedDay: Date) {
        this.selectedDay = selectedDay;
        this.submitList(list);
    }
}