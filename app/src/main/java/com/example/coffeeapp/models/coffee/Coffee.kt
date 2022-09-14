package com.example.coffeeapp.models.coffee

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity
 class Coffee(
    @PrimaryKey
    val id:Int?=null,
    val name:String?=null,
    val price:Double?=null,
    val image:String?=null,
    val size:String?=null,
    val sugar:Int?=null,
    val isAddedToCart:Boolean?=null,
    val boughtItemsCount:Int?=null
    ):Serializable
