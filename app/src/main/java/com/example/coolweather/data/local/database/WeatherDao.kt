package com.example.coolweather.data.local.database


import androidx.room.*
import com.example.coolweather.data.constants.ConstantsKey
import com.example.coolweather.data.models.entities.WeatherEntity

@Dao
interface WeatherDao {

    @Query("SELECT * FROM ${ConstantsKey.WEATHER_DATABASE} WHERE cityName LIKE :name")
    suspend fun getByName(name: String?): WeatherEntity

    @Query("SELECT * FROM ${ConstantsKey.WEATHER_DATABASE}")
    suspend fun getAll(): List<WeatherEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOne(weather: WeatherEntity)

    @Delete
    suspend fun deleteOne(weather: WeatherEntity)
}