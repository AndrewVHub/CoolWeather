package com.example.coolweather.presentation.utils

import com.example.coolweather.data.models.ApiResponse
import com.example.coolweather.data.models.Weather
import com.example.coolweather.data.models.WeatherModel
import com.example.coolweather.data.models.WeatherResponse
import com.example.coolweather.data.models.entities.WeatherEntity
import com.example.coolweather.presentation.models.convertToUI
import com.example.coolweather.presentation.models.getWeatherImageEnum
import java.text.SimpleDateFormat
import java.util.*

fun ApiResponse<WeatherResponse>.toModel(): WeatherModel {
    return WeatherModel(
        data = data.map {
            Weather(
                cityName = city_name,
                sunrise = SimpleDateFormat("HH:mm").format(Date(it.sunrise_ts * 1000L)),
                sunset = SimpleDateFormat("HH:mm").format(Date(it.sunset_ts * 1000L)),
                windSpeed = it.wind_spd,
                weather = it.weather.description,
                pressure = it.pres,
                humidity = it.rh,
                ts = it.ts,
                temp = it.temp,
                image = getWeatherImageEnum(it.weather.description).convertToUI().image
            )
        }
    )
}

fun Weather.toEntity(): WeatherEntity {
    return WeatherEntity(
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