package com.example.coffeeapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coffeeapp.repository.CoffeeRepository
import com.example.coffeeapp.repository.DatabaseRepo

class DetailsViewModelProviderFactory(
    val repository: DatabaseRepo
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailsViewModel(repository) as T
    }
}