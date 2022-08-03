package com.example.ejerciciotcnicorappi.movies.data

import com.example.ejerciciotcnicorappi.movies.data.remote.MoviesRetrofitService

class MoviesRemoteDataSource (private val moviesRetrofitService: MoviesRetrofitService){

    fun getUpcomingMoviesList(apiKey: String) = moviesRetrofitService.getLatestList(apiKey)
}