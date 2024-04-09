package com.example.weather.Data.Remote

import android.app.Application
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    @Provides
    @Singleton
    fun createWeatherService(): WeatherApi {

        val logging = HttpLoggingInterceptor()
        logging.apply {
            HttpLoggingInterceptor.Level.BODY
        }

        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .client(client)

        return retrofit
            .build()
            .create(WeatherApi::class.java)
    }
    @Provides
    @Singleton
    fun provideFusedLocationProviderClient(app: Application): FusedLocationProviderClient {
        return LocationServices.getFusedLocationProviderClient(app)
    }
}