package com.example.coolweather.data.network

import com.example.coolweather.data.models.WeatherResponse


class ApiWorkerImpl(
    private val appService: AppService
): ApiWorker {
    override suspend fun getEpisode(): WeatherResponse = appService.getCoordinate()
}