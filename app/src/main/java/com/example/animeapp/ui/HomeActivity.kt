package com.example.animeapp.ui

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
        HomeViewModelFactory(AnimeRepository(RetrofitClient.apiService))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = AnimeAdapter(emptyList(), this)
        binding.recyclerView.adapter = adapter

        homeViewModel.getTopAnime { response ->
            if (response.isSuccessful) {
                val animeList = response.body()?.data ?: emptyList()
                adapter.updateData(animeList)
            } else {
                Toast.makeText(this, "Failed to load anime details", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
