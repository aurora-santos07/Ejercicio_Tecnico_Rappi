package com.example.ejerciciotcnicorappi.movies.domain

import com.example.ejerciciotcnicorappi.BuildConfig
import com.example.ejerciciotcnicorappi.movies.data.MoviesRepository

class GetMovieDetailUseCase(private val repository: MoviesRepository){

    fun getMovieDetailUseCase(movieId: Int) =
        repository.getMovieDetail(movieId, BuildConfig.API_KEY_TMDB, DEFAULT_LANGUAGE)
}