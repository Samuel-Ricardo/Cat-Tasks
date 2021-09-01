package com.study.kotlin.cattastk.presenter.adapter.task.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.study.kotlin.cattastk.data.entity.Task
import com.study.kotlin.cattastk.databinding.TaskLayoutBinding
import com.study.kotlin.cattastk.util.text.Text.getSummedUpText

class TaskViewHolder(
    private val binding: TaskLayoutBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Task){
        binding.taskTitle.text = item.title;
        binding.taskNotes.text = getSummedUpText(item.notes)
    }
}