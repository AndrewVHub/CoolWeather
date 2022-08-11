package com.example.coolweather.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.coolweather.data.models.entities.WeatherEntity

@Database(
    entities = [
        WeatherEntity::class
    ], version = 1
)
abstract class WeatherDatabase: RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}