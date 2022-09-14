package com.example.coffeeapp.models.coffee

import androidx.room.Entity
import androidx.room.PrimaryKey

class CoffeeDb (
    val id:Int,
    val name:String,
    val price:Double,
    val image:String,
    val size:String,
    val sugar:Int,
    val isAddedToCart:Boolean,
    val boughtItemsCount:Int
        ){

}