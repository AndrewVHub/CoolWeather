package com.example.coolweather.presentation.ui.home

import com.example.coolweather.data.local.database.WeatherDao
import com.example.coolweather.data.models.Weather
import com.example.coolweather.data.models.WeatherModel
import com.example.coolweather.data.network.ApiWorker
import com.example.coolweather.presentation.mapper.WeatherApiResponseToModel
import com.example.coolweather.presentation.mapper.WeatherModelToEntity
import javax.inject.Inject

class WeatherInteractor @Inject constructor(
    private val apiWorker: ApiWorker,
    private val weatherDao: WeatherDao
) {

    suspend fun getWeather(lang: String, lat: String, lon: String): WeatherModel{
        val array = apiWorker.getWeatherOne(lang, lat, lon)
        return WeatherApiResponseToModel.map(array)
    }

    suspend fun addCity(weatherModel: Weather){
        return weatherDao.insertOne(WeatherModelToEntity.map(weatherModel))
    }


}