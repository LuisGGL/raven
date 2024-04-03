package com.raven.home.domain.mapper

import com.raven.home.data.local.model.NewsEntity
import com.raven.home.data.remote.entities.response.NewsResponse
import com.raven.home.domain.entities.New
import com.raven.home.domain.entities.News
import javax.inject.Inject

class GetNewsMapper @Inject constructor() {

    fun remoteToLocal(params: NewsResponse): List<New>  {
        val data = mutableListOf<New>()
        var count = 0
        params.results.forEach {
            data.add(
                New(
                    title = it.title,
                    resume = it.abstract,
                    image = it.media.mediaData[2].url,
                    author = it.byLine,
                    date = it.publishedDate,
                    newsUrl = it.url,
                    section = it.newYorkTimesSection,
                    id = count.toString()
            ))
            count++
        }
        return data
    }

    fun remoteToDomain(params: NewsResponse): News  {
        val data = mutableListOf<New>()
        var count = 0
        params.results.forEach {
            data.add(
                New(
                    title = it.title,
                    resume = it.abstract,
                    image = it.media.mediaData[2].url,
                    author = it.byLine,
                    date = it.publishedDate,
                    newsUrl = it.url,
                    section = it.newYorkTimesSection,
                    id = count.toString()
                )
            )
            count++
        }
        return News(data)
    }

    fun localToDomain(params: List<NewsEntity>): News  {
        val data = mutableListOf<New>()
        params.forEach {
            data.add(
                New(
                    title = it.title,
                    resume = it.resume,
                    image = it.image,
                    author = it.author,
                    date = it.date,
                    newsUrl = it.newsUrl,
                    section = it.section,
                    id = it.id.toString()
                )
            )
        }
        return News(data)
    }
}
