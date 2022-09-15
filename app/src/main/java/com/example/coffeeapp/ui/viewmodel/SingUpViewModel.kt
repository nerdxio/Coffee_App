package com.example.coffeeapp.ui.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeeapp.models.response.UserCereatedResponse
import com.example.coffeeapp.models.user.User
import com.example.coffeeapp.repository.CoffeeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SingUpViewModel : ViewModel() {

    val repository: CoffeeRepository = CoffeeRepository()
    private val _registerLiveData = MutableLiveData<Boolean>()
    val registerLiveData: LiveData<Boolean> = _registerLiveData

    fun register(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                repository.register(user)
            }.onSuccess {
                _registerLiveData.postValue(true)
            }
                .onFailure {
                //Log.e("","", it)
            }


        }
    }


}