package com.study.kotlin.cattastk.presenter.adapter.task.viewholder

import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.study.kotlin.cattastk.R
import com.study.kotlin.cattastk.data.entity.Task
import com.study.kotlin.cattastk.databinding.TaskLayoutBinding
import com.study.kotlin.cattastk.presenter.adapter.task.TaskAdapter
import com.study.kotlin.cattastk.util.text.Text.getSummedUpText

class TaskViewHolder(
    private val binding: TaskLayoutBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Task, onClick: (Task) -> Unit, adapter: TaskAdapter){

        binding.taskTitle.text = item.title;
        binding.taskNotes.text = getSummedUpText(item.notes)
        binding.taskLayoutTime.text = item.time.toString();

        binding.taskLayoutBody.setOnClickListener { onClick(item) }

        binding.imgMore.setOnClickListener { showPopup(item, adapter) }
    }

    private fun showPopup(item: Task, adapter: TaskAdapter) {
        val more = binding.imgMore
        val popupMenu = PopupMenu(more.context, more)

        popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener {menuItem ->
            when(menuItem.itemId){
                R.id.action_edit -> adapter.listenerEdit(item)
                R.id.action_delete -> adapter.listenerDelete(item)
            }
            return@setOnMenuItemClickListener true
        }
        popupMenu.show()
    }
}