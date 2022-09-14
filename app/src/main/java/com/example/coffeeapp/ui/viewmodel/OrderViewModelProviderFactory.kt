package com.example.coffeeapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.coffeeapp.repository.DatabaseRepo

class OrderViewModelProviderFactory(
    val repository: DatabaseRepo
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return OrderViewModel(repository) as T
    }
}