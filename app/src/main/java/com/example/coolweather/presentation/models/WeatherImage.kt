package com.example.coolweather.presentation.models


enum class WeatherImage {
    SUN, SUN_CLOUD, MIN_RAIN, SOMEWHERE_CLOUD, CLOUD, RAIN, HARD_RAIN, UNKNOWN
}

fun getWeatherImageEnum(status: String) =
    when(status){
        "Преимущественно ясно" -> WeatherImage.SUN
        "Ясно" -> WeatherImage.SUN
        "Облачно с прояснениями" -> WeatherImage.SUN_CLOUD
        "Небольшой дождь" -> WeatherImage.MIN_RAIN
        "Местами небольшой дождь" -> WeatherImage.MIN_RAIN
        "Местами облачно" -> WeatherImage.SOMEWHERE_CLOUD
        "Облачно" -> WeatherImage.CLOUD
        "Дождь" -> WeatherImage.RAIN
        "Ливень" -> WeatherImage.HARD_RAIN
        "Дождь с грозой" -> WeatherImage.HARD_RAIN
        else -> WeatherImage.UNKNOWN
    }