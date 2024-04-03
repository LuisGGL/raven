package com.raven.home.domain.entities

data class New(
    val newsUrl: String,
    val date: String,
    val section: String,
    val author: String,
    val title: String,
    val resume: String,
    val image: String
)
