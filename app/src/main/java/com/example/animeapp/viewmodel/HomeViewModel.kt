package com.example.animeapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animeapp.repository.AnimeRepository
import com.example.animeapp.model.AnimeResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel(private val animeRepository: AnimeRepository) : ViewModel() {

    fun getTopAnime(onResult: (Response<AnimeResponse>) -> Unit) {
        viewModelScope.launch {
            try {
                val response = animeRepository.getTopAnime()
                onResult(response)
            } catch (e: Exception) {
                onResult(Response.error(400, null))
            }
        }
    }

}
