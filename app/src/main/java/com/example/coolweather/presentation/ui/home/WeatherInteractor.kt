package com.example.coolweather.presentation.ui.home

import com.example.coolweather.data.models.WeatherModel
import com.example.coolweather.data.network.ApiWorker
import com.example.coolweather.presentation.mapper.WeatherMapper
import javax.inject.Inject

class WeatherInteractor @Inject constructor(
    private val apiWorker: ApiWorker
) {
    suspend fun getSunInformation(): List<WeatherModel> = apiWorker.getEpisode().data.map {
        WeatherMapper.map(it)
    }

}