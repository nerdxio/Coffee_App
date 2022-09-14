package com.example.coffeeapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeeapp.models.coffee.Coffee
import com.example.coffeeapp.repository.CoffeeRepository
import com.example.coffeeapp.repository.DatabaseRepo
import kotlinx.coroutines.launch

class DetailsViewModel(private val repository: DatabaseRepo) : ViewModel() {


    fun insert(coffee:Coffee) {
        viewModelScope.launch {
            repository.inset(coffee)
        }
    }

}