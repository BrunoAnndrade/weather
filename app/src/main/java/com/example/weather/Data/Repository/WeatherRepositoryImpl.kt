package com.example.weather.Data.Repository

import com.example.weather.Data.Remote.WeatherApi
import com.example.weather.Data.Remote.WeatherResponse
import com.example.weather.Domain.Util.Resource
import com.example.weather.Domain.Repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherResponse> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                   latitude = lat,
                    longitude = long,
                )
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}