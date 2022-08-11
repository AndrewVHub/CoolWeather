package com.example.coolweather.presentation.mapper

import com.example.coolweather.data.models.Weather
import com.example.coolweather.data.models.entities.WeatherEntity
import com.example.coolweather.presentation.mapper.base.Mapper

object WeatherModelToEntity : Mapper<Weather, WeatherEntity>() {
    override fun map(from: Weather): WeatherEntity = from.run {
        WeatherEntity(
            cityName = cityName,
            sunrise = sunrise,
            sunset = sunset,
            windSpeed = windSpeed,
            weather = weather,
            pressure = pressure,
            humidity = humidity,
            ts = ts,
            temp = temp,
            image = image
        )
    }
}