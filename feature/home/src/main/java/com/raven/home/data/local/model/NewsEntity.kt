package com.raven.home.data.local.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "news_table")
data class NewsEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val newsUrl: String,
    val date: String,
    val section: String,
    val author: String,
    val title: String,
    val resume: String,
    val image: String
) : Parcelable
