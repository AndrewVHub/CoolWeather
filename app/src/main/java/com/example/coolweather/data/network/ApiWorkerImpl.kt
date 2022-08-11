package com.example.coolweather.data.network

import com.example.coolweather.data.models.ApiResponse
import com.example.coolweather.data.models.WeatherResponse


class ApiWorkerImpl(
    private val appService: AppService
): ApiWorker {
    override suspend fun getWeatherOne(lang: String, lat: String,lon: String): ApiResponse<WeatherResponse> = appService.getWeather(lang, lat, lon)
}