package com.example.coolweather.data.network

import com.example.coolweather.data.constants.ConstantsKey
import com.example.coolweather.data.models.ApiResponse
import com.example.coolweather.data.models.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface AppService {

    @Headers(
        ConstantsKey.HEADER_ONE,
        ConstantsKey.HEADER_TWO
    )
    @GET("forecast/daily?units=metric")
    suspend fun getWeather(
        @Query("lang") lang: String,
        @Query("lat") lat: String,
        @Query("lon") lon: String): ApiResponse<WeatherResponse>


}
//@GET("forecast/minutely?lat=56.5&lon=84.97&units=metric&lang=ru&hours=12")