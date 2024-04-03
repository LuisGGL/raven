package com.raven.home.data.local.mapper

import com.raven.home.data.local.model.NewsEntity
import com.raven.home.domain.entities.New
import javax.inject.Inject

class NewsMapper @Inject constructor() {
    fun domainToRequest(info: List<New>): List<NewsEntity> {
        val news = mutableListOf<NewsEntity>()
        info.forEach {
            news.add(
                NewsEntity(
                newsUrl = it.newsUrl,
                date = it.date,
                section = it.section,
                author = it.author,
                title = it.title,
                resume = it.resume,
                image = it.image
            ))

        }

        return news
    }
}