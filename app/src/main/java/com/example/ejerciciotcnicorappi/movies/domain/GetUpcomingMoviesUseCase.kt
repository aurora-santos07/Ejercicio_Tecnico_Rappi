package com.example.ejerciciotcnicorappi.movies.domain

import com.example.ejerciciotcnicorappi.BuildConfig
import com.example.ejerciciotcnicorappi.movies.data.MoviesRepository

class GetUpcomingMoviesUseCase (private  val repository: MoviesRepository){

    fun getUpcomingMoviesList() = repository.getUpcomingMoviesList(BuildConfig.API_KEY_TMDB)
}