package com.example.coffeeapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeeapp.models.user.LoginResponse
import com.example.coffeeapp.models.user.UserLoginRequst

import com.example.coffeeapp.repository.CoffeeRepository
import kotlinx.coroutines.launch

class SingInViewModel : ViewModel() {

    val repository: CoffeeRepository = CoffeeRepository()
    private val _loginLiveData = MutableLiveData<LoginResponse>()
    val loginLiveData: LiveData<LoginResponse> = _loginLiveData

    fun login(email: String, password :String) {
        viewModelScope.launch {
            val loginResult = repository.loginUser(email, password)

            _loginLiveData.value = loginResult
        }
    }

}