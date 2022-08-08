package com.example.ejerciciotcnicorappi.movies.data

class MoviesRepository (private val remoteDataSource: MoviesRemoteDataSource) {

    fun getUpcomingMoviesList(apiKey: String, language: String) =
        remoteDataSource.getUpcomingMoviesList(apiKey, language)

    fun getTopRatedMoviesList(apiKey: String, language: String) =
        remoteDataSource.getTopRatedMoviesList(apiKey, language)

    fun getRecomendedMoviesList(movieId: Int, apiKey: String, language: String) =
        remoteDataSource.getRecomendedMoviesList(movieId, apiKey, language)

    fun getDiscoverList(year: Int, apiKey: String, language: String) =
        remoteDataSource.getDiscoverList(year, apiKey, language)

    fun getMovieDetail(movieId: Int, apiKey: String, language: String) =
        remoteDataSource.getMovieDetail(movieId, apiKey, language)
}