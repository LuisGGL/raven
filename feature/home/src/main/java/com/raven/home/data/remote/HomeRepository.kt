package com.raven.home.data.remote

import com.raven.home.data.Result
import com.raven.home.data.remote.entities.response.NewsResponse
import com.raven.home.data.remote.service.HomeService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val service: HomeService
) : HomeDataSource {
    override suspend fun getNews(): Flow<Result<NewsResponse>> {
        return flow {
            try {
                val response = service.getNews()
                emit(Result.Success(response))

            } catch (e: Exception) {
                emit(Result.Error("Error fetching data form remote source"))
            }
        }
    }


}
