package com.satyamthakur.bioguardian.data.datasource

import com.satyamthakur.bioguardian.data.api.ImagePredictionApiService
import com.satyamthakur.bioguardian.data.entity.AnimalPredictionResponse
import retrofit2.Response
import javax.inject.Inject

class AnimalPredictionDataImpl @Inject constructor(
    private val apiService: ImagePredictionApiService
) : AnimalPredictionData {
    override suspend fun getAnimalPrediction(): Response<AnimalPredictionResponse> {
        return apiService.getAnimalPrediction()
    }
}