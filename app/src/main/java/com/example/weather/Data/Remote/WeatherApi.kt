package com.example.weather.Data.Remote

import com.example.weather.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    //https://api.openweathermap.org/data/2.5/
    @GET("weather?units=metric&lang=pt_br")
    suspend fun getWeatherData(
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