package com.satyamthakur.bioguardian.data.datasource

import com.satyamthakur.bioguardian.data.entity.FakeApiResponse
import retrofit2.Response

interface PostsDataSource {

    suspend fun getPost(): Response<FakeApiResponse>

}