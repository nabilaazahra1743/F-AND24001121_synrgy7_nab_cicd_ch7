package com.example.listingmovie.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import com.chuckerteam.chucker.api.ChuckerInterceptor
import android.content.Context

class MovieApiService {
    companion object{
        private const val BASE_URL = "https://api.themoviedb.org/3/"
        private var retrofit : Retrofit? = null

        fun getInstance(): Retrofit{
            if (retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(OkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!

        }
    }


}