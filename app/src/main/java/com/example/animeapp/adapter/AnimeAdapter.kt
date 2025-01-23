package com.example.animeapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.example.animeapp.databinding.ItemAnimeBinding
import com.example.animeapp.model.Anime
import com.example.animeapp.ui.AnimeDetailActivity

class AnimeAdapter(private var animeList: List<Anime>, private val context: Context) :
    RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    inner class AnimeViewHolder(private val binding: ItemAnimeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(anime: Anime) {
            binding.textTitle.text = anime.title
            binding.textEpisodes.text = "Episodes: ${anime.episodes ?: "N/A"}"
            binding.textRating.text = "Rating: ${anime.score ?: "N/A"}"
            Picasso.get().load(anime.images.jpg.image_url).into(binding.imagePoster)

            binding.cardView.setOnClickListener {
                val intent = Intent(context, AnimeDetailActivity::class.java)
                intent.putExtra("anime_id", anime.mal_id)
                context.startActivity(intent)
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

    fun updateData(newList: List<Anime>) {
        animeList = newList
        notifyDataSetChanged()
    }
}
