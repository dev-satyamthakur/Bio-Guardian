package com.satyamthakur.bioguardian.data.datasource

import com.satyamthakur.bioguardian.data.entity.AnimalInfoResponse
import retrofit2.Response

interface AnimalDataInfo {

    suspend fun getAnimalData(): Response<AnimalInfoResponse>

}