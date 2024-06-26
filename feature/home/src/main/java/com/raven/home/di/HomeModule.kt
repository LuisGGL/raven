package com.raven.home.di

import com.raven.home.data.remote.HomeDataSource
import com.raven.home.data.remote.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeModule {

    @Binds
    abstract fun bindHiringSource(repository: HomeRepository): HomeDataSource
}
