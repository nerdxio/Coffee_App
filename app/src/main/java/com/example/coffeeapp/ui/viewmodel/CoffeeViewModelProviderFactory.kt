package com.example.coffeeapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coffeeapp.repository.CoffeeRepository

class CoffeeViewModelProviderFactory(
    val repository: CoffeeRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CoffeeViewModel(repository) as T
    }
}