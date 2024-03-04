package com.example.weather.Data.Remote.ForeCastModel

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)