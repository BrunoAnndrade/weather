package com.example.weather.Domain.Repository

import com.example.weather.Data.Remote.ForecastResponse
import com.example.weather.Domain.Util.Resource

interface ForecastRepository {
    suspend fun getForecastData(lat: Double, long: Double): Resource<ForecastResponse>
}