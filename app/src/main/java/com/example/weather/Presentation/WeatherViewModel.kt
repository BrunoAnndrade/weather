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

    private val _weatherLiveData = MutableLiveData<List<WeatherDTO>>()
    val weatherLiveData: LiveData<List<WeatherDTO>> = _weatherLiveData

    private val _windSpeedLiveData = MutableLiveData<WindDTO>()
    val windSpeedLiveData: LiveData<WindDTO> = _windSpeedLiveData

    init {
        getWeather()
    }

    private fun getWeather() {
        viewModelScope.launch {
            try {

                val latitude = 0.0
                val longitude = 0.0

                val weatherResponse = weatherService.fetchWeather(latitude, longitude)

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