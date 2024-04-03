package com.raven.home.data.local

import com.raven.home.data.local.dao.NewsDao
import com.raven.home.data.local.mapper.NewsMapper
import com.raven.home.data.local.model.NewsEntity
import com.raven.home.domain.entities.New
import com.raven.home.data.Result
import javax.inject.Inject

class NewsLocalRepository @Inject constructor(
    private val dao: NewsDao,
    private val mapper: NewsMapper
): NewsLocalDataSource {
    override suspend fun getNews(): Result<List<NewsEntity>?> {
        return try {
           Result.Success(dao.getAll())
        } catch (e: Exception) {
            Result.Error("Error fetching data from local storage")
        }
    }

    override suspend fun deleteNews(): Result<Unit> {
        return try {
        Result.Success(dao.deleteAll())
        } catch (e: Exception) {
            Result.Error("Error deleting data from local storage")
        }
    }

    override suspend fun addNews(news: List<New>): Result<Unit> {
        return try {
            Result.Success(dao.addAll(mapper.domainToRequest(news)))
        } catch (e: Exception) {
            Result.Error("Error updating data at local storage")
        }
    }
}