package com.raven.home.di

import com.raven.home.data.local.NewsLocalDataSource
import com.raven.home.data.local.NewsLocalRepository
import com.raven.home.data.remote.HomeDataSource
import com.raven.home.data.remote.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NewsDataModule {

    @Binds
    abstract fun bindNewsLocalDataSource(repository: NewsLocalRepository): NewsLocalDataSource

}