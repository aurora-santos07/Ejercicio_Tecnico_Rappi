package com.example.ejerciciotcnicorappi.movies.view.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejerciciotcnicorappi.databinding.LayoutMovieCarouselBinding
import com.example.ejerciciotcnicorappi.movies.view.models.MovieUI

class MoviessCarousel @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttribute: Int = 0):
    LinearLayout(context, attrs, defStyleAttribute){

    val carouselAdapter = MovieCarouselAdapter()
    private lateinit var moviessCarousel : LayoutMovieCarouselBinding

    init {
        moviessCarousel = LayoutMovieCarouselBinding.inflate(LayoutInflater.from(context), this, true)
        initRecyclerView()
    }

    fun initRecyclerView(){
        moviessCarousel.carousel.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

    }

    fun setMoviesList(moviesList: MutableList<MovieUI>, itemSelectedListener: ((String) -> Unit)){
        moviesList.let {
            if (moviesList.isNotEmpty()){
                carouselAdapter.setList(moviesList)
                carouselAdapter.onItemSelectedListener = itemSelectedListener
            }
        }
        moviessCarousel.carousel.adapter = carouselAdapter
    }

    fun setTitle(titleStr: String){
        titleStr.let {
            moviessCarousel.title.text = titleStr
        }
    }

    fun clear(){
        carouselAdapter.onItemSelectedListener = null
        moviessCarousel.carousel.adapter = null
    }
}
