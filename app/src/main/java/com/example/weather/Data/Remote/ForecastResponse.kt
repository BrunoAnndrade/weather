package com.example.weather.Data.Remote

data class ForecastResponse(
    val city: CityForecastDTO,
    val list: List<ListWeatherElementDTO>,
)

data class CityForecastDTO(
    val id:Int,
    val name:String
)

data class ListWeatherElementDTO(
    val dt: Int,
    val dt_txt: String,
    val main: MainWeatherDTO,
    val weather: List<WeatherDTO>,
)


