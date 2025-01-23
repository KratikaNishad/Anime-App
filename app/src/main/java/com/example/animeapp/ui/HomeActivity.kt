package com.example.animeapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animeapp.adapter.AnimeAdapter
import com.example.animeapp.databinding.ActivityHomeBinding
import com.example.animeapp.repository.AnimeRepository
import com.example.animeapp.network.RetrofitClient
import com.example.animeapp.viewmodel.HomeViewModel
import com.example.animeapp.viewmodel.HomeViewModelFactory

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val homeViewModel: HomeViewModel by viewModels {
        HomeViewModelFactory(AnimeRepository(RetrofitClient.apiService)) // Provide the API service
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = AnimeAdapter(emptyList()) // Initially empty list
        binding.recyclerView.adapter = adapter

        // Fetch top anime from the ViewModel and pass the result to the callback
        homeViewModel.getTopAnime { response ->
            if (response.isSuccessful) {
                val animeList = response.body()?.data ?: emptyList()
                adapter.updateData(animeList) // Update RecyclerView with fetched data
            } else {
                Toast.makeText(this, "Failed to load anime", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
