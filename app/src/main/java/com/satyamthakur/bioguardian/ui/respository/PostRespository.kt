package com.satyamthakur.bioguardian.ui.respository

import com.satyamthakur.bioguardian.data.datasource.PostsDataSource
import com.satyamthakur.bioguardian.data.entity.FakeApiResponse
import com.satyamthakur.bioguardian.data.entity.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class PostRespository @Inject constructor(
    private val postsDataSource: PostsDataSource
){
    suspend fun getPost(): Flow<ResourceState<FakeApiResponse>> {
        return flow {
            emit(ResourceState.Loading())

            val response = postsDataSource.getPost()
            if (response.isSuccessful && response.body() != null) {
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error("Something went wrong in fetching news!"))
            }

        }.catch { e ->
            emit(ResourceState.Error("Error: ${e.localizedMessage ?: "Something went wrong in flow"}"))
        }
    }
}