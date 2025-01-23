package com.example.animeapp.repository

import com.example.animeapp.model.AnimeResponse
import com.example.animeapp.network.ApiService
import com.example.animeapp.network.RetrofitClient
import retrofit2.Response

class AnimeRepository(private val apiService: ApiService) {

    suspend fun getTopAnime(): Response<AnimeResponse> {
        return apiService.getTopAnime()
    }
}
