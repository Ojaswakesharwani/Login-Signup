package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvm.databinding.ActivitySuccessBinding

class SuccessActivity : AppCompatActivity() {
    lateinit var binding: ActivitySuccessBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle=intent.extras
        val value=bundle?.getString("authentication")
        binding.tvWelcome.text="Welcome $value !"
    }
}