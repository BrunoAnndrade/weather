package com.example.weather.Data.Remote


data class WeatherResponse(
    val id: Int,
    val main: MainWeatherDTO,
    val weather: List<WeatherDTO>,
    val wind: WindDTO
)

data class MainWeatherDTO(
    val feels_like: Double,
    val humidity: Int,
    val temp: Double,
    val temp_max: Double,
    val temp_min: Double
)

data class WeatherDTO(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String,
)

data class WindDTO(
    val speed:Double
)

