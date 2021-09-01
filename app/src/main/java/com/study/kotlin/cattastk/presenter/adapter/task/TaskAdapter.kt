package com.study.kotlin.cattastk.presenter.adapter.task

import androidx.recyclerview.widget.DiffUtil
import com.study.kotlin.cattastk.data.entity.Task

class TaskAdapter {
}

class DiffCallback: DiffUtil.ItemCallback<Task>(){

    override fun areItemsTheSame(oldItem: Task, newItem: Task) = oldItem == newItem

    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean = oldItem.id == newItem.id
}