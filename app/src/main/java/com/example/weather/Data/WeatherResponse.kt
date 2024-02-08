package com.example.weather.Data

data class WeatherResponse(
    val lat: Double,
    val lon: Double,
    val timezone: String,
    val timezoneOffset: Long,
    val current:List<CurrentDto>,
    val weatherElement:WeatherElementDto,
    val daily:Daily,
    val temp:Temp
)

data class CurrentDto (
    val dt: Long,
    val temp: Double,
    val humidity: Long,
    val wind_speed: Double,
    val weather: List<WeatherElementDto>,

    )

data class WeatherElementDto (
    val id: Long,
    val main: String,
    val description: String,
    val icon: String
)

data class Daily (
    val dt: Long,
    val temp: Temp,
    val weather: List<WeatherElementDto>,
)

data class Temp (
    val day: Double,
    val min: Double,
    val max: Double,
    val night: Double,
    val eve: Double,
    val morn: Double
)




