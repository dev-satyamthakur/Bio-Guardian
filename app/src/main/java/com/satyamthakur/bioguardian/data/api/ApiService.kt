package com.satyamthakur.bioguardian.data.api

import com.satyamthakur.bioguardian.data.entity.FakeApiResponse
import retrofit2.Response;
import retrofit2.http.GET;

interface ApiService {
    @GET("posts/1")
    suspend fun getNewsHeadlines() : Response<FakeApiResponse>
}