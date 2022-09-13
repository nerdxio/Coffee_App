package com.example.coffeeapp.repository

import com.example.coffeeapp.data.remote.RetrofitInstance
import com.example.coffeeapp.models.coffee.Coffee
import com.example.coffeeapp.models.response.UserCereatedResponse
import com.example.coffeeapp.models.user.User
import retrofit2.Response

class CoffeeRepository {

    suspend fun getCoffee():Response<List<Coffee>>{
        return RetrofitInstance.api.getCoffee()
    }

    suspend fun loginUser(userinfo: HashMap<String, String>):Response<String>{
        return RetrofitInstance.api.loginUser(userinfo)
    }

    suspend fun register(user:User):Response<UserCereatedResponse>{
        return RetrofitInstance.api.register(user)
    }

}