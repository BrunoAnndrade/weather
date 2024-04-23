package com.example.weather.Presentation

import com.example.weather.Data.Remote.ForecastResponse
import com.example.weather.Data.Remote.WeatherResponse

data class WeatherState(
    val weatherResponse: WeatherResponse? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)

data class ForecastState(
    val forecastResponse: ForecastResponse? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)