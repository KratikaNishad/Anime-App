package com.example.animeapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.example.animeapp.databinding.ItemAnimeBinding
import com.example.animeapp.model.Anime

class AnimeAdapter(private var animeList: List<Anime>) : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    private var onItemClickListener: ((Anime) -> Unit)? = null

    inner class AnimeViewHolder(private val binding: ItemAnimeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(anime: Anime) {
            binding.textTitle.text = anime.title
            binding.textEpisodes.text = "Episodes: ${anime.episodes ?: "N/A"}"
            binding.textRating.text = "Rating: ${anime.score ?: "N/A"}"
            Picasso.get().load(anime.images.jpg.image_url).into(binding.imagePoster)

            // Set the click listener for the individual item
            binding.root.setOnClickListener {
                onItemClickListener?.invoke(anime)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val binding = ItemAnimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.bind(animeList[position])
    }

    override fun getItemCount() = animeList.size

    // Method to update the data in RecyclerView
    fun updateData(newList: List<Anime>) {
        animeList = newList
        notifyDataSetChanged()
    }

    // Set the click listener for items
    fun setOnItemClickListener(listener: (Anime) -> Unit) {
        onItemClickListener = listener
    }
}
