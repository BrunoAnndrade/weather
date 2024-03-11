package com.example.weather.Presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.Data.Remote.CityForecastDTO
import com.example.weather.Data.Remote.ListWeatherElementDTO


import com.example.weather.Data.Remote.RetrofitModule
import com.example.weather.Data.Remote.WeatherService
import kotlinx.coroutines.launch
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class ForecastViewModel(
    private val weatherService: WeatherService
) : ViewModel() {

    private val _CityLiveData = MutableLiveData<CityForecastDTO>()
    val CityLiveData: LiveData<CityForecastDTO> = _CityLiveData

    private val _ListElementLiveData = MutableLiveData<List<ListWeatherElementDTO>>()
    val ListElementLiveData: LiveData<List<ListWeatherElementDTO>> = _ListElementLiveData


    init {
        getForecast()
    }


    private fun getForecast() {
        viewModelScope.launch {
            try {
                val lat = -6.98021
                val lon = -34.8304
                val forecastResponse = weatherService.fetchForecast(lat, lon, 40)

                _CityLiveData.value = forecastResponse.city
                _ListElementLiveData.value = forecastResponse.list


            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
    }


    // Take date and transform it into a day of week
    fun getDayOfTheWeek(dtTxt: String): String {
        try {
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
            val date = sdf.parse(dtTxt)

            if (date != null) {
                val calendar = Calendar.getInstance()
                calendar.time = date
                return when (calendar.get(Calendar.DAY_OF_WEEK)) {
                    1 -> "Dom"
                    2 -> "Seg"
                    3 -> "Ter"
                    4 -> "Qua"
                    5 -> "Qui"
                    6 -> "Sex"
                    7 -> "Sáb"
                    else -> "Dia inválido"
                }
            } else {
                return "Formato de data inválido"
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
            return "Erro"
        }
    }

    companion object {
        fun create(): ForecastViewModel {
            val weatherService = RetrofitModule.createWeatherService()
            return ForecastViewModel(weatherService)

        }

    }


}