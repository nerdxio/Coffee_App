package com.example.coffeeapp.data.remote

import com.example.coffeeapp.models.coffee.Coffee
import com.example.coffeeapp.models.user.User
import com.example.coffeeapp.models.response.UserCereatedResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CoffeeService {

    @GET("api/items")
    suspend fun getCoffee():Response<List<Coffee>>

    @POST("api/login")
    suspend fun loginUser( @Body userinfo: HashMap<String, String>):Response<String>

    @POST("api/user/save")
    suspend fun register( @Body userinfo: User): Response<UserCereatedResponse>

    @POST("api/item")
    suspend fun addItem( @Body coffee: Coffee)

}