package com.example.coffeeapp.repository

import com.example.coffeeapp.data.local.CoffeeDatabase
import com.example.coffeeapp.models.coffee.Coffee

class DatabaseRepo (val db:CoffeeDatabase){
    suspend fun inset(coffee: Coffee) = db.getCoffeeDao().insert(coffee)

    fun getAllCoffee() = db.getCoffeeDao().getAllCoffees()

    suspend fun deleteAll() = db.getCoffeeDao().deleteAllCoffee()

}