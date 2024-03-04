package com.example.weather.Presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.weather.Data.Remote.RetrofitModule

import com.example.weather.Data.Remote.WeatherService
import com.example.weather.Data.Remote.WeatherModel.Main
import com.example.weather.Data.Remote.WeatherModel.Weather
import com.example.weather.Data.Remote.WeatherModel.Wind
import com.example.weather.Data.Remote.WeatherResponse
import kotlinx.coroutines.launch
import java.lang.Exception

class WeatherViewModel(
    private val weatherService: WeatherService

) :ViewModel(){

    private val _MainLiveData = MutableLiveData<Main>()
    val MainLiveData:LiveData<Main> = _MainLiveData

    private val _WeatherLiveData = MutableLiveData<List<Weather>>()
    val WeatherLiveData:LiveData<List<Weather>> = _WeatherLiveData

    private val _WindSpeedLiveData = MutableLiveData<Wind>()
    val WindSpeedLiveData:LiveData<Wind> = _WindSpeedLiveData

    init {
        getWeather()
    }
    private fun getWeather(){
        viewModelScope.launch {
            try {
                val lat = -6.98021
                val lon = -34.8304
                val weatherResponse = weatherService.fetchWeather(lat,lon)
                _MainLiveData.value = weatherResponse.main
                _WeatherLiveData.value = weatherResponse.weather
                _WindSpeedLiveData.value = weatherResponse.wind



            } catch (ex: Exception){
                ex.printStackTrace()
            }
        }
    }

    companion object{
        fun create(): WeatherViewModel {
            val weatherService = RetrofitModule.createWeatherService()
            return WeatherViewModel(weatherService)

        }

    }
}