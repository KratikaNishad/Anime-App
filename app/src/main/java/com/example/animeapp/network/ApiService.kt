package com.example.animeapp.network
import com.example.animeapp.model.AnimeDetail
import com.example.animeapp.model.AnimeResponse
import retrofit2.http.GET
import retrofit2.Response
import retrofit2.http.Path

interface ApiService {
    @GET("top/anime")
    suspend fun getTopAnime(): Response<AnimeResponse>

    @GET("anime/{anime_id}")
    suspend fun getAnimeDetails(@Path("anime_id") animeId: Int): Response<AnimeDetail>
}