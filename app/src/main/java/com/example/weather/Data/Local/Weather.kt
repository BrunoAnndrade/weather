package com.example.weather.Data.Local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.weather.Data.Remote.MainWeatherDTO
import com.example.weather.Data.Remote.WeatherDTO
import com.example.weather.Data.Remote.WindDTO

@Entity
class mainWeather(
    @PrimaryKey(autoGenerate = true) val id:Int,
    val weatherId: Int,
    val wind: WindDTO,
    val feels_like: Double,
    val humidity: Int,
    val temp: Double,
    val temp_max: Double,
    val temp_min: Double,
    val dt: Int,
    val dt_txt: String,

)

