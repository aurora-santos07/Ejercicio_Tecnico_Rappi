package com.example.ejerciciotcnicorappi.movies.view.widgets

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejerciciotcnicorappi.databinding.LayoutMovieItemBinding
import com.example.ejerciciotcnicorappi.movies.view.models.MovieUI

class MovieCarouselAdapter() : RecyclerView.Adapter<MovieCarouselViewHolder>(){

    private val moviesList = mutableListOf<MovieUI>()
    var onItemSelectedListener: ((Int?) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MovieCarouselViewHolder(LayoutMovieItemBinding.inflate(LayoutInflater.from(parent.context)))

    override fun onBindViewHolder(holder: MovieCarouselViewHolder, position: Int) {
        var movie = moviesList[position]
        holder.bind(movie, onItemSelectedListener)
    }

    override fun getItemCount() = moviesList.size

    fun setList(mutableList: MutableList<MovieUI>){
        moviesList.addAll(mutableList)
    }

}
