package com.example.coolweather.data.models.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.coolweather.data.constants.ConstantsKey

@Entity(tableName = ConstantsKey.WEATHER_DATABASE)
data class WeatherEntity(
    @PrimaryKey @ColumnInfo(name = "cityName") val cityName: String,
    @ColumnInfo(name = "sunrise") val sunrise: String,
    @ColumnInfo(name = "sunset") val sunset: String,
    @ColumnInfo(name = "windSpeed") val windSpeed: Float,
    @ColumnInfo(name = "pressure") val pressure: Float,
    @ColumnInfo(name = "humidity") val humidity: Int,
    @ColumnInfo(name = "ts") val ts: Int,
    @ColumnInfo(name = "image") val image: Int,
    @ColumnInfo(name = "temp") val temp: Float,
    @ColumnInfo(name = "weather") val weather: String
)
