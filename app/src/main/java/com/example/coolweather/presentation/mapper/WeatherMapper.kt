package com.example.coolweather.presentation.mapper

import com.example.coolweather.data.models.WeatherBodyResponse
import com.example.coolweather.data.models.WeatherModel
import com.example.coolweather.presentation.mapper.base.Mapper
import java.text.SimpleDateFormat
import java.util.*

object WeatherMapper: Mapper<WeatherBodyResponse, WeatherModel>() {
    override fun map(from: WeatherBodyResponse): WeatherModel = from.run {
        WeatherModel(
            SimpleDateFormat("HH:mm").format(Date (sunrise_ts*1000L)),
            SimpleDateFormat("HH:mm").format(Date (sunset_ts*1000L)),
            wind_spd,
            pres,
            rh,
            temp,
            weather
        )
    }
}
