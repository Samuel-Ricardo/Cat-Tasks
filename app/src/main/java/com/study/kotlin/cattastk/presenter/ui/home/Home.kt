package com.study.kotlin.cattastk.presenter.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.study.kotlin.cattastk.App
import com.study.kotlin.cattastk.R
import com.study.kotlin.cattastk.databinding.ActivityHomeBinding
import com.study.kotlin.cattastk.domain.TaskUseCase
import com.study.kotlin.cattastk.presenter.adapter.task.TaskAdapter
import com.study.kotlin.cattastk.presenter.viewmodel.MainViewModel
import com.study.kotlin.cattastk.presenter.viewmodel.factory.MainViewModelFactory

class Home : AppCompatActivity() {

    companion object {
        private const val CREATE_NEW_TASK = 1000
    }

    val binding by lazy {ActivityHomeBinding.inflate(layoutInflater)}
    val viewModel by viewModels<MainViewModel> {
        MainViewModelFactory(
            TaskUseCase((application as App).repository)
        )
    }
    val adapter by lazy {TaskAdapter()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setup()
    }

    private fun setup() {
        setupList();
        setupListeners()
    }

    private fun setupList() {
        binding.rcvTasksList.adapter = this.adapter;
        updateList();
    }

    private fun updateList() {
        viewModel.getAll().observe(this, {task ->
            adapter.submitList(task)
        })
    }

}
