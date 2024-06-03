package com.example.listingmovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.listingmovie.databinding.MovieItemBinding
import com.example.listingmovie.models.Movie
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class MovieAdapter(private val callback: List<Movie>):
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    private val diffCallback = object : DiffUtil.ItemCallback<Movie>(){
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
           return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    class MovieViewHolder(val binding: MovieItemBinding) : ViewHolder(binding.root){
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500"
        fun bind(data: Movie, callback: (Movie) -> Unit){
            binding.movieTitle.text = data.title
            binding.releaseDate.text = data.release

            Glide.with(binding.moviePoster.context)
                .load(IMAGE_BASE)
                .apply(RequestOptions())
                .into(binding.moviePoster)

            binding.root.setOnClickListener{
                callback(data)
            }
        }

        fun bind(data: Movie?, callback: List<Movie>) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int{
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(differ.currentList[position], callback)
    }
}