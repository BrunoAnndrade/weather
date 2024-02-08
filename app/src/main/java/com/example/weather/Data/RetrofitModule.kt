package com.example.weather.Data

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitModule {

        fun createWeatherService():WeatherService{

            val logging = HttpLoggingInterceptor()
            logging.apply {
                HttpLoggingInterceptor.Level.BODY
            }

            val client: OkHttpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            val retrofit = Retrofit
                .Builder()
                .baseUrl("https://api.openweathermap.org/data/3.0/")
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .client(client)

            return retrofit
                .build()
                .create(WeatherService::class.java)
        }
}