package com.example.ejerciciotcnicorappi.movies.domain

import com.example.ejerciciotcnicorappi.BuildConfig
import com.example.ejerciciotcnicorappi.movies.data.MoviesRepository

class GetDiscoverMoviesUseCase(private val repository: MoviesRepository) {

    fun getDiscoverMoviesListUseCase()=
        repository.getDiscoverList(DEFAULT_YEAR, BuildConfig.API_KEY_TMDB, DEFAULT_LANGUAGE)
}