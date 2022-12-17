package com.example.galleryapp.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImagesResponse(
    @Json(name = "hits")
    val hits: MutableList<Hit>,
    @Json(name = "total")
    val total: Int,
    @Json(name = "totalHits")
    val totalHits: Int
)