package com.example.weather.Data.Remote

import com.example.weather.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    //https://api.openweathermap.org/data/3.0/onecall
    @GET("weather?units=metric&lang=pt_br")
    suspend fun fetchWeather(
        @Query("lat") latitude:Double,
        @Query("lon") longitude:Double,
        @Query("appid") apiKey:String = BuildConfig.API_KEY
    ): WeatherResponse

    @GET("forecast?units=metric&lang=pt_br")
    suspend fun fetchForecast(
        @Query("lat") latitude:Double,
        @Query("lon") longitude:Double,
        @Query("cnt") count: Int,
        @Query("appid") apiKey:String = BuildConfig.API_KEY
    ): ForecastResponse
}