package com.satyamthakur.bioguardian.ui.respository

import com.satyamthakur.bioguardian.data.datasource.AnimalDataInfo
import com.satyamthakur.bioguardian.data.entity.AnimalInfoResponse
import com.satyamthakur.bioguardian.data.entity.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class AnimalRepository @Inject constructor(
    private val animalDataSource: AnimalDataInfo
){
    suspend fun getPost(): Flow<ResourceState<AnimalInfoResponse>> {
        return flow {
            emit(ResourceState.Loading())

            val response = animalDataSource.getAnimalData()
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