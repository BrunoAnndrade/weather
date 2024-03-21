package com.example.weather.Data.Remote

data class ForecastResponse(
    val city: CityForecastDTO,
    val list: List<ListWeatherElementDTO>,
)

data class CityForecastDTO(
    val id:Int,
    val name:String
)
data class ForecastWeatherDTO(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)
data class WindDTO(
    val speed: Double
)

