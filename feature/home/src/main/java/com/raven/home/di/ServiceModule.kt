package com.raven.home.di

import com.raven.home.data.remote.service.HomeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {
    @Provides
    @Singleton
    fun provideNewsService(retrofit: Retrofit): HomeService {
        return retrofit.create(HomeService::class.java)
    }
}