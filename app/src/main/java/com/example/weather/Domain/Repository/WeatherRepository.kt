package com.example.weather.Domain.Repository

import com.example.weather.Data.Remote.WeatherResponse
import com.example.weather.Domain.Util.Resource

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherResponse>
}