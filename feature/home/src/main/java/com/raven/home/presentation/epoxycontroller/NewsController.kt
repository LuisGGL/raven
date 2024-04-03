package com.raven.home.presentation.epoxycontroller

import android.view.View
import com.airbnb.epoxy.EpoxyController
import com.raven.core.bases.NavigationListener
import com.raven.core.bases.util.NewsHelper
import com.raven.home.domain.entities.New
import com.raven.home.newItem

class NewsController(
    private val listener: NavigationListener
) : EpoxyController() {

    var news: List<New> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }

    override fun buildModels() {
        news.forEach {
            newItem {
                id(it.id)
                news(it)
                onClick { _: View ->
                    NewsHelper.newsUrl = it.newsUrl
                    NewsHelper.image = it.image
                    NewsHelper.id = it.id
                    NewsHelper.date = it.date
                    NewsHelper.author = it.author
                    NewsHelper.section = it.section
                    NewsHelper.resume = it.resume
                    NewsHelper.title = it.title

                    listener.goToNewsDetail()
                }
            }
        }
    }


}