package com.example.ejerciciotcnicorappi.movies.view.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejerciciotcnicorappi.databinding.LayoutMovieCarouselBinding
import com.example.ejerciciotcnicorappi.movies.view.extensions.hide
import com.example.ejerciciotcnicorappi.movies.view.models.MovieUI

class MoviessCarousel @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttribute: Int = 0):
    LinearLayout(context, attrs, defStyleAttribute){

    val carouselAdapter = MovieCarouselAdapter()
    var viewType = TYPE_LAYOUT_LINEAR
    private lateinit var moviessCarousel : LayoutMovieCarouselBinding

    init {
        moviessCarousel = LayoutMovieCarouselBinding.inflate(
            LayoutInflater.from(context), this, true)
    }

    fun initRecyclerView(){
        if (viewType == TYPE_LAYOUT_LINEAR) {
            moviessCarousel.carousel.layoutManager = LinearLayoutManager(
                context, LinearLayoutManager.HORIZONTAL, false
            )
        }else {
            moviessCarousel.carousel.layoutManager = GridLayoutManager(context, NUMBER_COLUMN)
        }

    }

    fun setMoviesList(moviesList: MutableList<MovieUI>, itemSelectedListener: ((Int?) -> Unit)){
        moviesList.let {
            if (moviesList.isNotEmpty()){
                carouselAdapter.setList(moviesList)
                carouselAdapter.onItemSelectedListener = itemSelectedListener
            }
        }
        moviessCarousel.carousel.adapter = carouselAdapter
    }

    fun setTitle(titleStr: String){
        if(titleStr.isNullOrBlank()) {
            moviessCarousel.title.hide()
        }else{
            moviessCarousel.title.text = titleStr
        }
    }

    fun clear(){
        carouselAdapter.onItemSelectedListener = null
        moviessCarousel.carousel.adapter = null
    }

    companion object{
        const val TYPE_LAYOUT_GRID = 1
        const val TYPE_LAYOUT_LINEAR = 2
        const val NUMBER_COLUMN = 2
    }
}
