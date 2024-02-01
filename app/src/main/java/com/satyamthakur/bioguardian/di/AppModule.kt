package com.satyamthakur.bioguardian.di

import com.satyamthakur.bioguardian.data.api.ApiService
import com.satyamthakur.bioguardian.data.datasource.PostDataSourceImpl
import com.satyamthakur.bioguardian.data.datasource.PostsDataSource
import com.satyamthakur.bioguardian.ui.respository.PostRespository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun providesNewsDataSource(apiService: ApiService): PostsDataSource {
        return PostDataSourceImpl(apiService)
    }

    @Singleton
    @Provides
    fun providesPostRepository(postDataSource: PostsDataSource): PostRespository {
        return PostRespository(postDataSource)
    }

}