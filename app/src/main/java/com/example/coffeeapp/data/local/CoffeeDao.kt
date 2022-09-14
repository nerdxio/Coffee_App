package com.example.coffeeapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.coffeeapp.models.coffee.Coffee


@Dao
interface CoffeeDao {

    //insert and update article if it exist
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Coffee): Long

    @Query("SELECT * FROM coffee")
    fun getAllCoffees(): LiveData<List<Coffee>>

    @Query("DELETE FROM coffee")
    suspend fun deleteAllCoffee()

}