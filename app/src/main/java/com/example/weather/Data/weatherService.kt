package com.example.weather.Data

interface weatherService {


    //https://api.openweathermap.org/data/3.0/onecall
    suspend fun fetchWeather():Weather
}