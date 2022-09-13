package com.example.coffeeapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coffeeapp.R
import com.example.coffeeapp.databinding.ActivityMainBinding
import com.example.coffeeapp.databinding.ActivityVerificationBinding

class VerificationActivity : AppCompatActivity() {
    lateinit var binding: ActivityVerificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
    }
}