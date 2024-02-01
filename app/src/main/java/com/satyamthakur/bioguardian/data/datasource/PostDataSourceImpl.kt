package com.satyamthakur.bioguardian.data.datasource

import com.satyamthakur.bioguardian.data.api.ApiService
import com.satyamthakur.bioguardian.data.entity.FakeApiResponse
import retrofit2.Response
import javax.inject.Inject


class PostDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : PostsDataSource {
    override suspend fun getPost(): Response<FakeApiResponse> {
        return apiService.getNewsHeadlines()
    }
}