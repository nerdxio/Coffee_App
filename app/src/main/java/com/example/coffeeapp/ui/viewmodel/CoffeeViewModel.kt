package com.example.coffeeapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeeapp.models.coffee.Coffee
import com.example.coffeeapp.repository.CoffeeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CoffeeViewModel(private val repository: CoffeeRepository) :ViewModel() {

    private val _coffeeLiveData = MutableLiveData<List<Coffee>>()
    val coffeeLiveData:LiveData<List<Coffee>> =_coffeeLiveData

    init {
        getCoffee()
    }
    private fun getCoffee(){
        viewModelScope.launch {
            val response = repository.getCoffee()
            _coffeeLiveData.value =response.body()
        }
    }

}