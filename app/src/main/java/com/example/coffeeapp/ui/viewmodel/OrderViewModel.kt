package com.example.coffeeapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coffeeapp.models.coffee.Coffee
import com.example.coffeeapp.repository.DatabaseRepo

class OrderViewModel (private val repository: DatabaseRepo):ViewModel() {

   fun getSaveCoffee() =repository.getAllCoffee()
}