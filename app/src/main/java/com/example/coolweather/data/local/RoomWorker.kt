package com.example.coolweather.data.local

import com.example.coolweather.data.models.entities.WeatherEntity

interface RoomWorker {

    suspend fun getAllCities(): List<WeatherEntity>

    suspend fun getCityByName(name: String): WeatherEntity

    suspend  fun addCity(weatherEntity: WeatherEntity)

    suspend  fun deleteCity(weatherEntity: WeatherEntity)
}