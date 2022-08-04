package com.example.ejerciciotcnicorappi.movies.domain

import com.example.ejerciciotcnicorappi.BuildConfig
import com.example.ejerciciotcnicorappi.movies.data.MoviesRepository

class GetRecomendedMoviesUseCase(private val repository: MoviesRepository) {

    fun getRecomendedMoviesUseCase(movieId: Int) =
        repository.getRecomendedMoviesList(movieId, BuildConfig.API_KEY_TMDB, "es-MX")
}