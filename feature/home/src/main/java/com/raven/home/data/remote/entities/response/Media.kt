package com.raven.home.data.remote.entities.response

import com.google.gson.annotations.SerializedName

data class Media(
    val type: String,
    val subtype: String,
    @SerializedName("media-metadata")
    val mediaData: List<MediaData>
)
