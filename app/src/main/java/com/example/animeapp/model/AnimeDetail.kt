package com.example.animeapp.model

data class AnimeDetail(
    val data: AnimeData
)

data class AnimeData(
    val title: String,
    val synopsis: String,
    val genres: List<Genre>,
    val themes: List<CastMember>,
    val episodes: Int?,
    val rating: String?,
    val trailer: Trailer?,
    val images: AnimeImages
)

data class Genre(
    val name: String
)

data class CastMember(
    val name: String
)

data class Trailer(
    val youtube_id: String?
)

data class AnimeImages(
    val jpg: JpgImages
)

data class JpgImages(
    val image_url: String
)
