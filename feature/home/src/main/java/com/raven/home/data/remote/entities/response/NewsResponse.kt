package com.raven.home.data.remote.entities.response

data class NewsResponse(
    val status: String,
    val results: List<NewResponse>
)
