package com.raven.home.data.remote.service

import com.raven.home.data.remote.entities.response.NewResponse
import com.raven.home.data.remote.entities.response.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeService {

    @GET("svc/mostpopular/v2/emailed/{period}.json")
    suspend fun getNews(
        @Path("period") days: Int = 7
    ): NewsResponse
}
