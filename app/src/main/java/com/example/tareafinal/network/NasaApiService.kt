package com.example.tareafinal.network

import com.example.tareafinal.model.AstronomyPictureResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaApiService {
    @GET("planetary/apod")
    fun getAstronomyPictureOfTheDay(
        @Query("api_key") apiKey: String
    ): Call<AstronomyPictureResponse>
}
