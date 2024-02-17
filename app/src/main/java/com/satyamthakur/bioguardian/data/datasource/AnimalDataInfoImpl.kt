package com.satyamthakur.bioguardian.data.datasource

import com.satyamthakur.bioguardian.data.api.NinjaApiService
import com.satyamthakur.bioguardian.data.entity.AnimalInfoResponse
import retrofit2.Response
import javax.inject.Inject


class AnimalDataInfoImpl @Inject constructor(
    private val apiService: NinjaApiService
) : AnimalDataInfo {
    override suspend fun getAnimalData(): Response<AnimalInfoResponse> {
        return apiService.getAnimalInfo("Song Sparrow")
    }
}