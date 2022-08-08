package com.example.ejerciciotcnicorappi.movies.domain

import com.example.ejerciciotcnicorappi.BuildConfig
import com.example.ejerciciotcnicorappi.movies.data.MoviesRepository

class GetMovieVideosUseCase(private val repository: MoviesRepository) {

    fun getMovieVideosUseCase(idMovie: Int) =
        repository.getMovieVideos(idMovie, BuildConfig.API_KEY_TMDB, DEFAULT_LANGUAGE)
}