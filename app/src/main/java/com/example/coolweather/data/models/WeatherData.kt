package com.example.coolweather.data.models

import com.google.gson.annotations.SerializedName



data class WeatherModel(
    val data: List<Weather>
)

data class WeatherResponse(
    @SerializedName("sunrise_ts") val sunrise_ts: Int,
    @SerializedName("sunset_ts") val sunset_ts: Int,
    @SerializedName("wind_spd") val wind_spd: Float,
    @SerializedName("pres") val pres: Float,
    @SerializedName("rh") val rh: Int,
    @SerializedName("temp") val temp: Float,
    @SerializedName("ts") val ts: Int,
    @SerializedName("weather") val weather: WeatherDescription
)

data class Weather(
    val cityName: String,
    val sunrise: String,
    val sunset: String,
    val windSpeed: Float,
    val pressure: Float,
    val humidity: Int,
    val ts: Int,
    val image: Int,
    val temp: Float,
    val weather: String
)


data class WeatherDescription(
    val description: String
)
