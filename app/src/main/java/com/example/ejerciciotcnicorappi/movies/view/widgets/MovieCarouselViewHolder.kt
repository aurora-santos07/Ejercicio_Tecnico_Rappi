package com.example.ejerciciotcnicorappi.movies.view.widgets

import androidx.recyclerview.widget.RecyclerView
import com.example.ejerciciotcnicorappi.databinding.LayoutMovieItemBinding
import com.example.ejerciciotcnicorappi.movies.view.URL_IMAGES
import com.example.ejerciciotcnicorappi.movies.view.extensions.setImageByUrl
import com.example.ejerciciotcnicorappi.movies.view.models.MovieUI

class MovieCarouselViewHolder(val binding: LayoutMovieItemBinding):
    RecyclerView.ViewHolder(binding.root) {

    fun bind(movieUI: MovieUI, listener: ((Int?) -> Unit)?) = binding.run {
        imageView.setImageByUrl("$URL_IMAGES${movieUI.backDrop}")
        binding.root.setOnClickListener { listener?.invoke(movieUI.idMovieUi) }
    }

}
