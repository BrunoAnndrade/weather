package com.example.weather.Data.Local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ListMainWeather::class], version = 1)
abstract class ListMainWeatherDataBase:RoomDatabase() {

    abstract fun listMainWeatherDao():ListMainWeatherDao
}