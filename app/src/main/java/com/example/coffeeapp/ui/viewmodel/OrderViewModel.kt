package com.example.coffeeapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeeapp.models.coffee.Coffee
import com.example.coffeeapp.repository.DatabaseRepo
import kotlinx.coroutines.launch

class OrderViewModel (private val repository: DatabaseRepo):ViewModel() {

   fun getSaveCoffee() =repository.getAllCoffee()

   fun deleteAll(){
      viewModelScope.launch {
         repository.deleteAll()
      }
   }
}