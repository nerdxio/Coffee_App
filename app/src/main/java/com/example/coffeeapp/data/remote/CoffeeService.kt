package com.example.coffeeapp.data.remote

import com.example.coffeeapp.models.coffee.Coffee
import com.example.coffeeapp.models.user.User
import com.example.coffeeapp.models.response.UserCereatedResponse
import com.example.coffeeapp.models.user.LoginResponse
import com.example.coffeeapp.models.user.UserLoginRequst
import retrofit2.Response
import retrofit2.http.*

interface CoffeeService {

    @GET("api/items")
    suspend fun getCoffee():Response<List<Coffee>>

    @POST("api/login")
    suspend fun loginUser( @Body userLogin: UserLoginRequst):LoginResponse

    @GET("api/login")
    suspend fun loginUserGet( @Query("email") email: String, @Query("password") password : String):LoginResponse

    @POST("api/user/save")
    suspend fun register( @Body userinfo: User)

    @POST("api/item")
    suspend fun addItem( @Body coffee: Coffee)

}