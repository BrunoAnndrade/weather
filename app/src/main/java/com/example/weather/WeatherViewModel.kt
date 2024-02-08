package com.example.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.Data.CurrentDto
import com.example.weather.Data.RetrofitModule

import com.example.weather.Data.WeatherService
import kotlinx.coroutines.launch
import java.lang.Exception

class WeatherViewModel(
    private val weatherService: WeatherService

) :ViewModel(){

    private val _weatherLiveData = MutableLiveData<List<CurrentDto>>()
    val weatherLiveData:LiveData<List<CurrentDto>> = _weatherLiveData

    init {
        getWeather()
    }
    private fun getWeather(){
        viewModelScope.launch {
            try {
                val lat = -6.98021
                val lon = -34.8304
                val weather = weatherService.fetchWeather(lat,lon).current
                _weatherLiveData.value = weather

            } catch (ex: Exception){
                ex.printStackTrace()
            }
        }
    }

    companion object{
        fun create():WeatherViewModel{
            val weatherService = RetrofitModule.createWeatherService()
            return WeatherViewModel(weatherService)

        }

    }
}