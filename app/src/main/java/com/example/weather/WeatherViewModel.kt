package com.example.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.weather.Data.RetrofitModule

import com.example.weather.Data.WeatherService
import com.example.weather.Data.Weather.Main
import com.example.weather.Data.Weather.Weather
import com.example.weather.Data.Weather.WeatherResponse
import kotlinx.coroutines.launch
import java.lang.Exception

class WeatherViewModel(
    private val weatherService: WeatherService

) :ViewModel(){

    private val _MainLiveData = MutableLiveData<Main>()
    val MainLiveData:LiveData<Main> = _MainLiveData

    private val _nameLiveData = MutableLiveData<WeatherResponse>()
    val nameLiveData:LiveData<WeatherResponse> = _nameLiveData

    private val _WeatherLiveData = MutableLiveData<List<Weather>>()
    val WeatherLiveData:LiveData<List<Weather>> = _WeatherLiveData

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