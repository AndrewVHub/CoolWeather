package com.example.coolweather.data.local

import com.example.coolweather.data.local.database.WeatherDao
import com.example.coolweather.data.models.entities.WeatherEntity

class RoomWorkerImpl(
    private val weatherDao: WeatherDao
): RoomWorker {
    override suspend fun getAllCities(): List<WeatherEntity> = weatherDao.getAll()

    override suspend fun getCityByName(name: String): WeatherEntity = weatherDao.getByName(name)

    override suspend fun addCity(weatherEntity: WeatherEntity) = weatherDao.insertOne(weatherEntity)

    override suspend fun deleteCity(weatherEntity: WeatherEntity) = weatherDao.deleteOne(weatherEntity)
}