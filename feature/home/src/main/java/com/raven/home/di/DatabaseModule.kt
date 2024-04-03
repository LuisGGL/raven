package com.raven.home.di

import android.app.Application
import androidx.room.Room
import com.raven.home.data.local.database.NewsDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): NewsDataBase {
        return Room.databaseBuilder(application, NewsDataBase::class.java, "news_table")
            .fallbackToDestructiveMigration()
            .build()
    }

}