package com.study.kotlin.cattastk.presenter.ui.main

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.study.kotlin.cattastk.R
import com.study.kotlin.cattastk.databinding.ActivityMainBinding
import com.study.kotlin.cattastk.presenter.ui.home.Home

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    fun goToHome(view: View){
        val intent:Intent = Intent(this, Home::class.java)
        startActivity(intent);
    }
}
