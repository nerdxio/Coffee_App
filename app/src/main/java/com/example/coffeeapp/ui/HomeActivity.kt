package com.example.coffeeapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.coffeeapp.R
import com.example.coffeeapp.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ismaeldivita.chipnavigation.ChipNavigationBar

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()
        // may be there is an error here
        val bottomNavigationView= findViewById<BottomNavigationView>(R.id.bottom_nav_bar)

        val navController2 = findNavController(R.id.nav_controller2)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment,R.id.orderFragment,R.id.paymentFragment,R.id.profileFragment))
        setupActionBarWithNavController(navController2,appBarConfiguration)
        bottomNavigationView.setupWithNavController(navController2)
    }
}