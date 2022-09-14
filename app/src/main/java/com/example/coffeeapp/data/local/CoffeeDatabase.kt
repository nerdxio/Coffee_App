package com.example.coffeeapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.coffeeapp.models.coffee.Coffee

@Database(entities = [Coffee::class], version = 2)
abstract class CoffeeDatabase
    : RoomDatabase() {

    abstract fun getCoffeeDao(): CoffeeDao

    //singleton
    companion object {
        @Volatile
        private var instance: CoffeeDatabase? = null

        private val LOCK = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: creatDatabase(context).also {
                instance = it
            }
        }

        private fun creatDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                CoffeeDatabase::class.java,
                "coffee.db"
            ).build()
    }
}