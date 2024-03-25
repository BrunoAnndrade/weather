package com.example.weather.Data


data class WeatherResponse(
    val id: Int,
    val main: MainWeatherDTO,
    val weather: WeatherDTO,
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

data class ListWeatherElementDTO(
    val dt: Int,
    val dt_txt: String,
    val main: MainWeatherDTO,
    val weather: List<WeatherDTO>,
)

