package com.example.weather.Domain.DepedencyInjection

import com.example.weather.Data.Repository.ForecastRepositoryImpl
import com.example.weather.Data.Repository.WeatherRepositoryImpl
import com.example.weather.Domain.Repository.ForecastRepository
import com.example.weather.Domain.Repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class ForecastRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindForecastRepository(
        forecastRepositoryImpl: ForecastRepositoryImpl
    ): ForecastRepository
}