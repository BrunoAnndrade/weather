package com.example.weather.Data



data class Weather (
    val timezoneOffset: Long,
    val current: Current,
    val hourly: List<Current>,
    val daily: List<Daily>,
)
data class Current (
    val dt: Long,
    val temp: Double,
    val humidity: Long,
    val windSpeed: Double,
    val weather: List<WeatherElement>,

)

data class WeatherElement (
    val id: Long,
    val main: String,
    val description: String,
    val icon: String
)

data class Daily (
    val dt: Long,
    val temp: Temp,
    val weather: List<WeatherElement>,
)

data class Temp (
    val day: Double,
    val min: Double,
    val max: Double,
    val night: Double,
    val eve: Double,
    val morn: Double
)


