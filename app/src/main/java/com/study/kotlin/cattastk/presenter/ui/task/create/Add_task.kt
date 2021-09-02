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
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.study.kotlin.cattastk.App
import com.study.kotlin.cattastk.R
import com.study.kotlin.cattastk.data.entity.Task
import com.study.kotlin.cattastk.databinding.ActivityAddTaskBinding
import com.study.kotlin.cattastk.presenter.viewmodel.MainViewModel
import com.study.kotlin.cattastk.presenter.viewmodel.factory.MainViewModelFactory
import com.study.kotlin.cattastk.util.format
import com.study.kotlin.cattastk.util.text
import java.time.LocalDate
import java.util.*


class add_task : AppCompatActivity() {

    companion object {
        const val TASK_ID = "task_id"
    }

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
//        binding.homeToolbar.navigationIcon

        binding.btnSaveTask.setOnClickListener {
            viewModel.insert(generateTask())
            setResult(Activity.RESULT_OK)
            Toast.makeText(
                this,
                "Tarefa Agendada",
                Toast.LENGTH_LONG
            )
        }

        binding.inputDate.editText?.setOnClickListener{

            val datePicker =  MaterialDatePicker.Builder.datePicker().build()

            datePicker.addOnPositiveButtonClickListener {
                val timeZone = TimeZone.getDefault()
                val offset = timeZone.getOffset(Date().time)*-1

                binding.inputDate.text = Date(it + offset).format()
            }
            datePicker.show(supportFragmentManager, "DATE_PICKER_TAG")
        }

        binding.inputTime.editText?.setOnClickListener {
            val timePicker = MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .build()

            timePicker.addOnPositiveButtonClickListener {
                val minute = if (timePicker.minute in 0..9) "0${timePicker.minute}" else timePicker.minute
                val hour = if (timePicker.hour in 0..9) "0${timePicker.hour}" else timePicker.hour

                binding.inputTime.editText?.text?.clear();
                binding.inputTime.editText?.text?.insert(0, "$hour:$minute")
            }
            timePicker.show(supportFragmentManager, null)
        }
    }

    private fun generateTask(): Task {
        return Task(
            id = -1,
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

        /*
        AlertDialog
            .Builder(this)
                .setTitle("Armazenamento")
                .setMessage("Precisamos que você permita o acesso ao armazenamento para poder salvar as Tasks / Tarefas")
                .show()
        */

        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            1
        ).also {  }

        requestPermissions(
            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE
            ),
            1
        )
    }
}
