package com.raven.home.domain.usecases

import com.raven.core.bases.BaseUseCase
import com.raven.home.data.local.NewsLocalDataSource
import com.raven.home.data.remote.HomeDataSource
import com.raven.home.domain.entities.News
import com.raven.home.domain.mapper.GetNewsMapper
import com.raven.home.data.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GeNewsUseCase @Inject constructor(
    private val remoteDataSource: HomeDataSource,
    private val localDataSource: NewsLocalDataSource,
    private val mapper: GetNewsMapper
) : BaseUseCase<Unit, Result<News>>() {

    override fun execute(params: Unit): Flow<Result<News>> = flow {
        remoteDataSource.getNews().collect() { result ->
            if (result is Result.Success) {
                localDataSource.deleteNews()
                localDataSource.addNews(mapper.remoteToLocal(result.data))
                emit(Result.Success(mapper.remoteToDomain(result.data)))
            } else {
                localDataSource.getNews().let {
                    if (it is Result.Success && !it.data.isNullOrEmpty()) {
                      emit(Result.Success(mapper.localToDomain(it.data)))
                    } else if (it is Result.Error) {
                        emit(Result.Error(it.message))
                    } else {
                        emit(Result.Error("Unable to retrieve data, please try again later."))
                    }
                }
            }
        }
    }
}
