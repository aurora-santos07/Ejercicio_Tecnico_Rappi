package com.example.ejerciciotcnicorappi.view.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejerciciotcnicorappi.databinding.LayoutMovieCarouselBinding
import com.example.ejerciciotcnicorappi.view.models.MovieUI
import java.util.zip.Inflater

class MoviessCarousel (context: Context, attrs: AttributeSet? = null, defStyleAttribute: Int = 0):
    LinearLayout(context, attrs, defStyleAttribute){

    val carouselAdapter = MovieCarouselAdapter()
    val moviessCarousel = LayoutMovieCarouselBinding.inflate(LayoutInflater.from(context))

    init {
        initRecyclerView()
    }

    fun initRecyclerView(){
        moviessCarousel.carousel.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    fun setMoviesLint(moviesList: MutableList<MovieUI>, itemSelectedListener: ((String) -> Unit)){
        moviesList.let {
            if (moviesList.isNotEmpty()){
                carouselAdapter.setList(moviesList)
                carouselAdapter.onItemSelectedListener = itemSelectedListener
            }
        }
        moviessCarousel.carousel.adapter = carouselAdapter
    }

    fun clear(){
        carouselAdapter.onItemSelectedListener = null
        moviessCarousel.carousel.adapter = null
    }
}
