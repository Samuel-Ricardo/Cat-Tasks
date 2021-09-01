package com.study.kotlin.cattastk.presenter.adapter.task

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.study.kotlin.cattastk.data.entity.Task
import com.study.kotlin.cattastk.databinding.TaskLayoutBinding
import com.study.kotlin.cattastk.presenter.adapter.task.diff.DiffCallback
import com.study.kotlin.cattastk.presenter.adapter.task.viewholder.TaskViewHolder

class TaskAdapter: ListAdapter<Task,TaskViewHolder>(DiffCallback()) {

    var listenerEdit: (Task) -> Unit = {}
    var listenerDelete: (Task) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val infalter = LayoutInflater.from(parent.context)
        val binding = TaskLayoutBinding.inflate(infalter, parent, false)

        return TaskViewHolder(binding);
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}