package com.example.coolweather.data.network

import com.example.coolweather.data.models.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface AppService {

    @Headers(
        "X-RapidAPI-Key: f46ca84d80mshefbe10045e4b631p16d73bjsn1ad46830ba3e",
        "X-RapidAPI-Host: weatherbit-v1-mashape.p.rapidapi.com"
    )
    @GET("forecast/daily?lat=54.9999016666666&lon=82.983026666666&units=metric&lang=ru")
    suspend fun getCoordinate(): WeatherResponse
}