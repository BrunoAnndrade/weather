package com.example.weather.Data.Remote

import com.example.weather.Data.Remote.ForeCastModel.City
import com.example.weather.Data.Remote.ForeCastModel.Clouds
import com.example.weather.Data.Remote.ForeCastModel.ListElement
import com.example.weather.Data.Remote.ForeCastModel.Main
import com.example.weather.Data.Remote.ForeCastModel.Rain
import com.example.weather.Data.Remote.ForeCastModel.Sys
import com.example.weather.Data.Remote.ForeCastModel.Weather
import com.example.weather.Data.Remote.ForeCastModel.Wind

data class ForecastResponse(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<ListElement>,
    val message: Int
)

