package com.example.weather.Data.Remote

import com.example.weather.Data.Remote.WeatherModel.Clouds
import com.example.weather.Data.Remote.WeatherModel.Coord
import com.example.weather.Data.Remote.WeatherModel.Main
import com.example.weather.Data.Remote.WeatherModel.Rain
import com.example.weather.Data.Remote.WeatherModel.Sys
import com.example.weather.Data.Remote.WeatherModel.Weather
import com.example.weather.Data.Remote.WeatherModel.Wind

data class WeatherResponse(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val rain: Rain,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)