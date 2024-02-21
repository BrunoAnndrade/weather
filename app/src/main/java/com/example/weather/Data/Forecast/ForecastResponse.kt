package com.example.weather.Data.Forecast

data class ForecastResponse(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<ListElement>,
    val message: Int
)

data class ListElement(
    val clouds: Clouds,
    val dt: Int,
    val dt_txt: String,
    val main: Main,
    val pop: Double,
    val rain: Rain,
    val sys: Sys,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)