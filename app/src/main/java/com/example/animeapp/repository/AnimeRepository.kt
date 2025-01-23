package com.example.animeapp.repository

import com.example.animeapp.model.AnimeDetail
import com.example.animeapp.model.AnimeResponse
import com.example.animeapp.network.ApiService
import retrofit2.Response

class AnimeRepository(private val apiService: ApiService) {

    suspend fun getTopAnime(): Response<AnimeResponse> {
        return apiService.getTopAnime()
    }

    suspend fun getAnimeDetails(animeId: Int): Response<AnimeDetail> {
        return apiService.getAnimeDetails(animeId)
    }
}
