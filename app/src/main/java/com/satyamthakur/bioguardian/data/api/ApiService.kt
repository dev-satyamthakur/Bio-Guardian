package com.satyamthakur.bioguardian.data.api

import com.satyamthakur.bioguardian.BuildConfig
import com.satyamthakur.bioguardian.data.entity.AnimalInfoResponse
import com.satyamthakur.bioguardian.data.entity.AnimalPredictionResponse
import com.satyamthakur.bioguardian.data.entity.FakeApiResponse
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header
import retrofit2.http.Query

interface NinjaApiService {
    @GET("animals")
    suspend fun getAnimalInfo(
        @Query("name") animalName: String,
        @Header("x-api-key") xApiKey: String = BuildConfig.API_NINJA
    ): Response<AnimalInfoResponse>
}

interface ImagePredictionApiService {
    @GET("2")
    suspend fun getAnimalPrediction(
        @Query("api_key") apiKey: String = BuildConfig.API_DETECT,
        @Query("image") imageUrl: String = "https://www.istockphoto.com/photo/song-sparrow-perched-on-a-wood-gm1368317578-438329228"
    ): Response<AnimalPredictionResponse>
}