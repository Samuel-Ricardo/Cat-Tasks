package com.study.kotlin.cattastk.presenter.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.study.kotlin.cattastk.domain.TaskUseCase
import com.study.kotlin.cattastk.interfaces.TasksRepository
import com.study.kotlin.cattastk.presenter.viewmodel.MainViewModel

class MainViewModelFactory(private val useCase: TaskUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(useCase) as T
        }
    }
}