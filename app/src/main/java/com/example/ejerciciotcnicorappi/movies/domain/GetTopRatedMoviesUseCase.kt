package com.example.ejerciciotcnicorappi.movies.domain

import com.example.ejerciciotcnicorappi.BuildConfig
import com.example.ejerciciotcnicorappi.movies.data.MoviesRepository

class GetTopRatedMoviesUseCase (private  val repository: MoviesRepository){

    fun getTopRatedMoviesList() = repository.getTopRatedMoviesList(BuildConfig.API_KEY_TMDB, "es-MX")
}