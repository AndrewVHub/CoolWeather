package com.example.coolweather.presentation.models

import androidx.annotation.DrawableRes
import com.example.coolweather.R

enum class WeatherImageUI(
    @DrawableRes
    val image: Int
) {
    //, SUN, SUN_CLOUD, MIN_RAIN, SOMEWHERE_CLOUD, CLOUD, RAIN, HARD_RAIN, UNKNOWN
    SUN(
        R.drawable.ic_sun
    ),
    SUN_CLOUD(
        R.drawable.ic_sun_cloud
    ),
    MIN_RAIN(
        R.drawable.ic_min_rain
    ),
    SOMEWHERE_CLOUD(
        R.drawable.ic_somewhere_cloud
    ),
    CLOUD(
        R.drawable.ic_cloud
    ),
    RAIN(
        R.drawable.ic_rain
    ),
    HARD_RAIN(
        R.drawable.ic_hard_rain
    ),
    UNKNOWN(
        R.drawable.ic_moon
    )
}

fun WeatherImage.convertToUI(): WeatherImageUI{
    return when (this){
        WeatherImage.HARD_RAIN -> WeatherImageUI.HARD_RAIN
        WeatherImage.UNKNOWN -> WeatherImageUI.UNKNOWN
        WeatherImage.RAIN -> WeatherImageUI.RAIN
        WeatherImage.CLOUD -> WeatherImageUI.CLOUD
        WeatherImage.SOMEWHERE_CLOUD -> WeatherImageUI.SOMEWHERE_CLOUD
        WeatherImage.MIN_RAIN -> WeatherImageUI.MIN_RAIN
        WeatherImage.SUN_CLOUD -> WeatherImageUI.SUN_CLOUD
        WeatherImage.SUN -> WeatherImageUI.SUN
    }
}