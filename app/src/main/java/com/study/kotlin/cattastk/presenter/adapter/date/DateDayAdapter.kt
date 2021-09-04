package com.study.kotlin.cattastk.presenter.adapter.date

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.study.kotlin.cattastk.databinding.DateDayBinding
import com.study.kotlin.cattastk.domain.model.Date
import com.study.kotlin.cattastk.presenter.adapter.date.viewholder.DateDayViewHolder

class DateDayAdapter(
    var days: List<Date>,
    val onClick: ((Date, Int) -> Unit)
): RecyclerView.Adapter<DateDayViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateDayViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DateDayBinding.inflate(inflater, parent, false)

        Log.e("INFO", "CREATING DATE DAY HOLDER")

        return (DateDayViewHolder(binding))
    }

    override fun onBindViewHolder(holder: DateDayViewHolder, position: Int) {

        val now = Date.now()

        var select = {

        }

        if(now.isEquals(days[position])){

            holder.bind(
                days[position],
                position,
                true,
                onClick
            )
        }else{
            holder.bind(days[position], position, false, onClick)
        }



    }

    override fun getItemCount(): Int = days.size

    fun setItems(days: List<Date>){
        this.days = days;
    }
}