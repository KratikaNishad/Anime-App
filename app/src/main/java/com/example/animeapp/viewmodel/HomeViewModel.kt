package com.example.animeapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animeapp.model.AnimeDetail
import com.example.animeapp.repository.AnimeRepository
import com.example.animeapp.model.AnimeResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel(private val animeRepository: AnimeRepository) : ViewModel() {

    fun getTopAnime(onResult: (Response<AnimeResponse>) -> Unit) {
        viewModelScope.launch {
            try {
                val response = animeRepository.getTopAnime()
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        onResult(response)
                    } else {
                        onResult(Response.error(404, null))
                    }
                } else {
                    onResult(Response.error(response.code(), response.errorBody()))
                }
            } catch (e: Exception) {
                val errorResponse = Response.error<AnimeResponse>(500, null)
                onResult(errorResponse)
            }
        }
    }

    fun getAnimeDetails(animeId: Int, onResult: (Response<AnimeDetail>) -> Unit) {
        viewModelScope.launch {
            try {
                val response = animeRepository.getAnimeDetails(animeId)
                onResult(response)
            } catch (e: Exception) {
                onResult(Response.error(400, null))
            }
        }
    }
}
