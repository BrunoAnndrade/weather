package com.example.weather.Data

import com.example.weather.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherService {

    //https://api.openweathermap.org/data/3.0/onecall
    @GET("onecall?appid=${BuildConfig.API_KEY}")
    suspend fun fetchWeather(
        @Query("lat") latitude:Double,
        @Query("lon") longitude:Double,
    ):WeatherResponse
}