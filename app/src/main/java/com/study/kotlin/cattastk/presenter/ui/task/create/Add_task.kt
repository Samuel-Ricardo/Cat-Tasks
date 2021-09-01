package com.study.kotlin.cattastk.presenter.ui.task.create

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import com.google.android.material.textfield.TextInputLayout
import com.study.kotlin.cattastk.App
import com.study.kotlin.cattastk.R
import com.study.kotlin.cattastk.data.entity.Task
import com.study.kotlin.cattastk.databinding.ActivityAddTaskBinding
import com.study.kotlin.cattastk.presenter.viewmodel.MainViewModel
import com.study.kotlin.cattastk.presenter.viewmodel.factory.MainViewModelFactory
import java.time.LocalDate


class add_task : AppCompatActivity() {

    val binding by lazy { ActivityAddTaskBinding.inflate(layoutInflater) }
    val viewModel: MainViewModel by viewModels { MainViewModelFactory((application as App).taskUseCase) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setup()
    }

    private fun setup() {
        setupPermissions()
        setupListener()
    }

    private fun setupListener() {
        binding.btnSaveTask.setOnClickListener {
            viewModel.insert(generateTask())
            setResult(Activity.RESULT_OK)
            Toast.makeText(
                this,
                "Tarefa Agendada",
                Toast.LENGTH_LONG
            )
        }
    }

    private fun generateTask(): Task {
        return Task(
            id= -1,
            title = textOf(binding.inputTitle),
            notes = textOf(binding.inputNotes),
            date = textOf(binding.inputDate),
            time = textOf(binding.inputTime)
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun textToLocalDate(text: String): LocalDate {
        val date = text.split("/")

        return LocalDate.of(
            date[0].toInt(),
            date[1].toInt(),
            date[2].toInt())
    }

    private fun textOf(textInput: TextInputLayout) = textInput.editText?.text.toString()

    private fun setupPermissions() {

        AlertDialog
            .Builder(this)
                .setTitle("Armazenamento")
                .setMessage("Precisamos que você permita o acesso ao armazenamento para poder salvar as Tasks / Tarefas")
                .show()

        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            1
        )

        requestPermissions(
            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE
            ),
            1
        )
    }
}
