package com.study.kotlin.cattastk.presenter.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.study.kotlin.cattastk.R
import com.study.kotlin.cattastk.databinding.ActivityHomeBinding
import com.study.kotlin.cattastk.presenter.adapter.task.TaskAdapter

class Home : AppCompatActivity() {

    val binding by lazy {ActivityHomeBinding.inflate(layoutInflater)}
    val adapter by lazy {TaskAdapter()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setup()
    }

    private fun setup() {
        TODO("Not yet implemented")
    }


}
