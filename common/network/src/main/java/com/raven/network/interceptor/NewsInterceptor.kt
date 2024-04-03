package com.raven.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsInterceptor @Inject constructor(): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request().url
        val authUrl = url.newBuilder().addQueryParameter("api-key", API_KEY).build()
        return chain.proceed(chain.request().newBuilder().url(authUrl).build())
    }

    companion object {
        const val API_KEY = "eG7tS8rkXsGIPCbG8WbuenfYE2OGYB3k"
    }
}