package com.example.coolweather.data.models

import com.google.gson.annotations.SerializedName

data class ApiResponse<T>(
    @SerializedName("data") val data: List<T>,
    @SerializedName("city_name") val city_name: String
)