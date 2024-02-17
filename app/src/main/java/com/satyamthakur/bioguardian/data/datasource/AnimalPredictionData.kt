package com.satyamthakur.bioguardian.data.datasource

import com.satyamthakur.bioguardian.data.entity.AnimalPredictionResponse
import retrofit2.Response

interface AnimalPredictionData {
    suspend fun getAnimalPrediction(): Response<AnimalPredictionResponse>
}