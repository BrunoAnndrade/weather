package com.example.weather.Data.Remote

data class ForecastResponse(
    val city: CityForecastDTO,
    val list: List<ListForecastElementDTO>,
)

data class CityForecastDTO(
    val id:Int,
    val name:String
)

data class ListForecastElementDTO(
    val dt: Int,
    val dt_txt: String,
    val main: MainWeatherDTO,
    val weather: ForecastWeatherDTO,
)

data class ForecastWeatherDTO(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String,
)



