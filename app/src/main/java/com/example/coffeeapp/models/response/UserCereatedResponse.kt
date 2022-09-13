package com.example.coffeeapp.models.response

data class UserCereatedResponse(
    val email: String,
    val id: Int,
    val name: String,
    val password: String,
    val role: List<Any>,
    val userName: String
)