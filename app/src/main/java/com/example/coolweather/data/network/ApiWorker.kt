package com.example.coolweather.data.network

import com.example.coolweather.data.models.ApiResponse
import com.example.coolweather.data.models.WeatherResponse


interface ApiWorker {
    suspend fun getWeatherOne(lang: String, lat: String, lon: String): ApiResponse<WeatherResponse>
}