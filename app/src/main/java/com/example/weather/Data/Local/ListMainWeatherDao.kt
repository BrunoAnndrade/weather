package com.example.weather.Data.Local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
@Dao
interface ListMainWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListMainWeather(listMainWeather: ListMainWeather)
    @Query("SELECT * FROM main_weather")
    suspend fun getListMainWeather():ListMainWeather
}