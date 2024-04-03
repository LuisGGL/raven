package com.raven.home.data.remote

import com.raven.home.data.Result
import com.raven.home.data.remote.entities.response.NewsResponse
import kotlinx.coroutines.flow.Flow

interface HomeDataSource {
    suspend fun getNews(): Flow<Result<NewsResponse>>

}