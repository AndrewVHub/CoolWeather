package com.example.coolweather.presentation.ui.home

import com.example.coolweather.data.local.database.WeatherDao
import com.example.coolweather.data.models.Weather
import com.example.coolweather.data.models.WeatherModel
import com.example.coolweather.data.network.ApiWorker
import com.example.coolweather.presentation.utils.toEntity
import com.example.coolweather.presentation.utils.toModel
import javax.inject.Inject

class WeatherInteractor @Inject constructor(
    private val apiWorker: ApiWorker,
    private val weatherDao: WeatherDao
) {

    suspend fun getWeather(lang: String, lat: String, lon: String): WeatherModel = apiWorker.getWeatherOne(lang, lat, lon).toModel()

    suspend fun addCity(weatherModel: Weather) = weatherDao.insertOne(weatherModel.toEntity())


}