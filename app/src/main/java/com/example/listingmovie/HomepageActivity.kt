package com.example.listingmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listingmovie.databinding.ActivityHomepageBinding
import com.example.listingmovie.models.Movie
import com.example.listingmovie.models.MovieResponse
import com.example.listingmovie.services.MovieApiInterface
import com.example.listingmovie.services.MovieApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomepageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomepageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvMovieList.layoutManager = LinearLayoutManager(this)
        binding.rvMovieList.setHasFixedSize(true)

        getMovieData { movies: List<Movie> ->
            binding.rvMovieList.adapter = MovieAdapter(movies)
        }
    }

    private fun getMovieData(callback: (List<Movie>) -> Unit){
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object: Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }

        })

    }
}