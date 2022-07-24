package com.example.coolweather.data.models

import com.google.gson.annotations.SerializedName

data class WeatherBodyResponse(
    @SerializedName("sunrise_ts") val sunrise_ts: Int,
    @SerializedName("sunset_ts") val sunset_ts: Int,
    @SerializedName("wind_spd") val wind_spd: Float,
    @SerializedName("pres") val pres: Float,
    @SerializedName("rh") val rh: Int,
    @SerializedName("temp") val temp: Float,
    @SerializedName("weather") val weather: WeatherDescription
)

data class WeatherModel(
    val sunrise_ts: String,
    val sunset_ts: String,
    val wind_spd: Float,
    val pres: Float,
    val rh: Int,
    val temp: Float,
    val weather: WeatherDescription
)

data class WeatherDescription(
    val description: String
)

data class WeatherResponse(
    @SerializedName("data") val data: List<WeatherBodyResponse>
)