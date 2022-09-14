package com.example.coffeeapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeeapp.models.response.UserCereatedResponse
import com.example.coffeeapp.models.user.User
import com.example.coffeeapp.repository.CoffeeRepository
import kotlinx.coroutines.launch

class SingUpViewModel : ViewModel() {

    val repository: CoffeeRepository = CoffeeRepository()
    private val _registerLiveData = MutableLiveData<UserCereatedResponse>()
    val registerLiveData: LiveData<UserCereatedResponse> = _registerLiveData

    fun register(user: User) {
        viewModelScope.launch {
            val response = repository.register(user)
            if (response.isSuccessful) {
                _registerLiveData.value = repository.register(user).body()
            }else
            {

            }

        }
    }


}