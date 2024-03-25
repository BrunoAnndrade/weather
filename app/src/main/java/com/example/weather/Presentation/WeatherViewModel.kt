package com.example.weather.Presentation


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.Data.MainWeatherDTO
import com.example.weather.Data.RetrofitModule
import com.example.weather.Data.WeatherDTO
import com.example.weather.Data.WeatherService
import com.example.weather.Data.WindDTO
import kotlinx.coroutines.launch
import java.lang.Exception

class WeatherViewModel(
    private val weatherService: WeatherService
) : ViewModel() {


    private val _mainLiveData = MutableLiveData<MainWeatherDTO>()
    val mainLiveData: LiveData<MainWeatherDTO> = _mainLiveData

    private val _weatherLiveData = MutableLiveData<WeatherDTO>()
    val weatherLiveData: LiveData<WeatherDTO> = _weatherLiveData

    private val _windSpeedLiveData = MutableLiveData<WindDTO>()
    val windSpeedLiveData: LiveData<WindDTO> = _windSpeedLiveData

    init {
        getWeather()
    }

    private fun getWeather() {
        viewModelScope.launch {
            try {
                val lat = -6.98021
                val lon = -34.8304
                val weatherResponse = weatherService.fetchWeather(lat, lon)

                _mainLiveData.value = weatherResponse.main
                _weatherLiveData.value = weatherResponse.weather
                _windSpeedLiveData.value = weatherResponse.wind

            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
    }

    companion object {
        fun create(): WeatherViewModel {
            val weatherService = RetrofitModule.createWeatherService()
            return WeatherViewModel(weatherService)
        }
    }
}