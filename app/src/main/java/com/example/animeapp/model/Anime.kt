package com.example.animeapp.model

data class Anime(
    val id: Int,
    val title: String,
    val episodes: Int?,
    val score: Double?,
    val images: Image,
    val mal_id: Int
)

data class Image(
    val jpg: Jpg
)

data class Jpg(
    val image_url: String
)
