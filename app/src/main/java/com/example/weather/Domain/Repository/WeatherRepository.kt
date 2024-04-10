package com.example.weather.Domain.Repository

import com.example.weather.Data.Remote.WeatherResponse
import com.example.weather.Domain.Util.Resource


/* Interface for accessing weather data from a remote data source.
 This interface defines a method to fetch weather data based on latitude and longitude coordinates.
 The method is suspending and returns a Resource object encapsulating the result.
 The Resource object contains either a WeatherResponse on success or an error message on failure.
 */
interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherResponse>
}