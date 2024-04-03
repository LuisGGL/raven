package com.raven.home.data.remote.entities.response

import com.google.gson.annotations.SerializedName

data class NewResponse(
    val url: String,
    @SerializedName("published_date")
    val publishedDate: String,
    @SerializedName("nytdsection")
    val newYorkTimesSection: String,
    @SerializedName("byline")
    val byLine: String,
    val title: String,
    val abstract: String,
    val media: Media
)
