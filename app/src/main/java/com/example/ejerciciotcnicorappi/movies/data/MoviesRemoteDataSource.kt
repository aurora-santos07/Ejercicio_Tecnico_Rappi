package com.example.ejerciciotcnicorappi.movies.data

import com.example.ejerciciotcnicorappi.movies.data.remote.MoviesRetrofitService

class MoviesRemoteDataSource (private val moviesRetrofitService: MoviesRetrofitService){

    fun getUpcomingMoviesList(apiKey: String, language: String) =
        moviesRetrofitService.getUpcomingList(apiKey, language)

    fun getTopRatedMoviesList(apiKey: String, language: String) =
        moviesRetrofitService.getTopRatedList(apiKey, language)
}