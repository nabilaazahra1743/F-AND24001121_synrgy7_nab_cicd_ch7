package com.example.listingmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listingmovie.adapter.MovieAdapter

class HomeActivity : AppCompatActivity() {

//    private lateinit var movieAdapter: MovieAdapter
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_home)
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_home, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        movieAdapter = MovieAdapter()
//        // Inisialisasi RecyclerView dan adapter
//        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
//        recyclerView.layoutManager = LinearLayoutManager(context)
//        recyclerView.adapter = movieAdapter
//
//        fetchMovies()
//    }
//
//    private fun fetchMovies() {
//        lifecycleScope.launch {
//            try {
//                val movies = RetrofitInstance.api.getMovies()
//                movieAdapter.submitList(movies)
//            } catch (e: Exception) {
//                // Handle error
//                e.printStackTrace()
//            }
//        }
//    }
//
//
//



}