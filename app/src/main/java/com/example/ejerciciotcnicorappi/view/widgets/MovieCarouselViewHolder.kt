package com.example.ejerciciotcnicorappi.view.widgets

import androidx.recyclerview.widget.RecyclerView
import com.example.ejerciciotcnicorappi.databinding.LayoutMovieItemBinding
import com.example.ejerciciotcnicorappi.view.URL_IMAGES
import com.example.ejerciciotcnicorappi.view.extensions.setImageByUrl
import com.example.ejerciciotcnicorappi.view.models.MovieUI

class MovieCarouselViewHolder(val binding: LayoutMovieItemBinding):
    RecyclerView.ViewHolder(binding.root) {

    fun bind(movieUI: MovieUI, listener: ((String) -> Unit)?) = binding.run {
        imageView.setImageByUrl("$URL_IMAGES${movieUI.backDrop}")
    }

}
