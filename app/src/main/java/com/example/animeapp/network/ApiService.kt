package com.example.animeapp.network
import com.example.animeapp.model.AnimeResponse
import retrofit2.http.GET
import retrofit2.Response
import retrofit2.http.Path

interface ApiService {
    @GET("top/anime")
    suspend fun getTopAnime(): Response<AnimeResponse>

}