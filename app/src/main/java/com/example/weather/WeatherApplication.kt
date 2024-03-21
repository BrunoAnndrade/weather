package com.example.weather

import android.app.Application
import androidx.room.Room
import com.example.weather.Data.Local.ListMainWeatherDataBase

class WeatherApplication : Application() {

    private lateinit var dataBase: ListMainWeatherDataBase
    override fun onCreate() {
        super.onCreate()

        //biblioteca api
        dataBase = Room.databaseBuilder(
            applicationContext,
            ListMainWeatherDataBase::class.java, "Weather-DataBase"
        ).build()
    }
    fun getAppDataBase(): ListMainWeatherDataBase {
        return dataBase
    }
}