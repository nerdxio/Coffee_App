package com.example.coffeeapp.repository

import android.util.Log
import com.example.coffeeapp.data.local.CoffeeDatabase
import com.example.coffeeapp.data.remote.RetrofitInstance
import com.example.coffeeapp.models.coffee.Coffee
import com.example.coffeeapp.models.response.UserCereatedResponse
import com.example.coffeeapp.models.user.LoginResponse
import com.example.coffeeapp.models.user.User
import com.example.coffeeapp.models.user.UserLoginRequst
import retrofit2.Response

class CoffeeRepository() {
    suspend fun getCoffee(): Response<List<Coffee>> {

        return RetrofitInstance.api.getCoffee()
    }

    suspend fun loginUser(email: String, password: String): LoginResponse {
        return try {

            //RetrofitInstance.api.loginUser(UserLoginRequst(email, password))
            RetrofitInstance.api.loginUserGet(email, password)
        } catch (e: Exception) {
            Log.e("LOGIN", e.localizedMessage)
            LoginResponse()

        }
    }


  suspend fun register(user: User) {
       return RetrofitInstance.api.register(user)
   }


}