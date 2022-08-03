package com.example.ejerciciotcnicorappi.movies.data

class MoviesRepository (private val remoteDataSource: MoviesRemoteDataSource) {

    fun getUpcomingMoviesList(apiKey: String) = remoteDataSource.getUpcomingMoviesList(apiKey)
}