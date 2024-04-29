package com.example.weather.Data.Repository


import com.example.weather.Data.Remote.ForecastResponse
import com.example.weather.Data.Remote.WeatherApi
import com.example.weather.Domain.Repository.ForecastRepository
import com.example.weather.Domain.Util.Resource
import javax.inject.Inject

class ForecastRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): ForecastRepository {
    override suspend fun getForecastData(lat: Double, long: Double): Resource<ForecastResponse> {

        return try {
            Resource.Success(
                data = api.getForecastData(
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