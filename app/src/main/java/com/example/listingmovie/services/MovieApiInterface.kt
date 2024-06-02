package com.example.listingmovie.services

import com.example.listingmovie.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {

    @GET("/movie/popular?api_key=8ab8606b224830f70aa2b9b4b5fbd054")
    fun getMovieList(): Call<MovieResponse>
}