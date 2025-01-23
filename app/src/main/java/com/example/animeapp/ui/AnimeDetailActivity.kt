package com.example.animeapp.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.animeapp.databinding.ActivityAnimeDetailBinding
import com.example.animeapp.network.RetrofitClient
import com.example.animeapp.repository.AnimeRepository
import com.example.animeapp.utils.InternetConnectivityCheck
import com.example.animeapp.viewmodel.HomeViewModel
import com.example.animeapp.viewmodel.HomeViewModelFactory
import com.squareup.picasso.Picasso

class AnimeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimeDetailBinding
    private val homeViewModel: HomeViewModel by viewModels {
        HomeViewModelFactory(AnimeRepository(RetrofitClient.apiService))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animeId = intent.getIntExtra("anime_id", 0)
        if (!InternetConnectivityCheck.isInternetAvailable(this)) {
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_LONG).show()
            return
        }

        homeViewModel.getAnimeDetails(animeId) { response ->
            if (response.isSuccessful) {
                val animeDetails = response.body()?.data
                animeDetails.let { details ->
                    binding.textTitle.text = details!!.title
                    binding.textSynopsis.text = details!!.synopsis
                    binding.textEpisodes.text = "Episodes: ${details.episodes ?: "N/A"}"
                    binding.textRating.text = "Rating: ${details.rating ?: "N/A"}"
                    binding.textGenres.text = "Genres: ${details.genres.joinToString(", ") { it.name }}"
                    if (!details.themes.isNullOrEmpty()) {
                    binding.textCast.text = "Main Cast: ${details.themes.joinToString(", ") { it.name }}"
                    } else {
                        binding.textCast.text = "Main Cast: N/A"
                    }


                    if (details.trailer?.youtube_id != null) {
                        val videoUrl = "https://www.youtube.com/watch?v=${details.trailer.youtube_id}"
                        binding.videoTrailer.setVideoPath(videoUrl)
                        binding.videoTrailer.start()
                    } else {
                        binding.imagePoster.visibility = android.view.View.VISIBLE
                        Picasso.get().load(details.images.jpg.image_url).into(binding.imagePoster)
                    }

                    if(!details.images.jpg.image_url.isNullOrEmpty()) {
                        Toast.makeText(this, "Video is not available for your country",Toast.LENGTH_SHORT)
                        binding.imagePoster.visibility = android.view.View.VISIBLE
                        Picasso.get().load(details.images.jpg.image_url).into(binding.imagePoster)
                    }
                }
            } else {
                Toast.makeText(this, "Failed to load anime details", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
