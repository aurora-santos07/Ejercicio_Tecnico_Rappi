package com.example.ejerciciotcnicorappi.movies.data

class MoviesRepository (private val remoteDataSource: MoviesRemoteDataSource) {

    fun getUpcomingMoviesList(apiKey: String, language: String) =
        remoteDataSource.getUpcomingMoviesList(apiKey, language)

    fun getTopRatedMoviesList(apiKey: String, language: String) =
        remoteDataSource.getTopRatedMoviesList(apiKey, language)
}