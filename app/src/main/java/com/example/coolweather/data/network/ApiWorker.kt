package com.example.coolweather.data.network

import com.example.coolweather.data.models.WeatherResponse


interface ApiWorker {
    suspend fun getEpisode(): WeatherResponse
}