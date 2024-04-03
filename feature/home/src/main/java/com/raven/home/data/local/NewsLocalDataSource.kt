package com.raven.home.data.local

import com.raven.home.data.local.model.NewsEntity
import com.raven.home.domain.entities.New
import com.raven.home.data.Result

interface NewsLocalDataSource {

    suspend fun getNews(): Result<List<NewsEntity>?>
    suspend fun deleteNews(): Result<Unit>
    suspend fun addNews(news: List<New>): Result<Unit>
}