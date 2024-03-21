package com.example.weather.Data.Local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.weather.Data.Remote.WindDTO

@Entity(tableName = "main_weather")
class ListMainWeather(
    @PrimaryKey(autoGenerate = true) val id:Int,
    val weatherId: Int,
    val feels_like: Double,
    val humidity: Int,
    val temp: Double,
    val temp_max: Double,
    val temp_min: Double,
    val icon:String,

)

