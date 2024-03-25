package com.example.weather.Data

data class ForecastResponse(
    val city: CityForecastDTO,
    val list: List<ListWeatherElementDTO>,
)

data class CityForecastDTO(
    val id:Int,
    val name:String
)

data class WindDTO(
    val speed: Double
)

