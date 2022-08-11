package com.example.coolweather.di

import android.content.Context
import androidx.room.Room
import com.example.coolweather.data.constants.ConstantsKey
import com.example.coolweather.data.local.database.WeatherDao
import com.example.coolweather.data.local.database.WeatherDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideApiService(@ApplicationContext appContext: Context): WeatherDatabase {
        return Room.databaseBuilder(
            appContext,
            WeatherDatabase::class.java,
            ConstantsKey.WEATHER_DATABASE
        ).build()
    }

    @Singleton
    @Provides
    fun providesProductDao(weatherDatabase: WeatherDatabase): WeatherDao {
        return weatherDatabase.weatherDao()
    }

}