package com.example.ejerciciotcnicorappi.movies.data

import com.example.ejerciciotcnicorappi.movies.data.remote.MoviesRetrofitService

class MoviesRemoteDataSource (private val moviesRetrofitService: MoviesRetrofitService){

    fun getUpcomingMoviesList(apiKey: String, language: String) =
        moviesRetrofitService.getUpcomingList(apiKey, language)

    fun getTopRatedMoviesList(apiKey: String, language: String) =
        moviesRetrofitService.getTopRatedList(apiKey, language)

    fun getRecomendedMoviesList(movieId: Int, apiKey: String, language: String) =
        moviesRetrofitService.getRecomendedList(movieId, apiKey, language)

    fun getDiscoverList(year: Int, apiKey: String, language: String) =
        moviesRetrofitService.getDiscoverList(year, apiKey, language)

    fun getMovieDetail(movieId: Int, apiKey: String, language: String) =
        moviesRetrofitService.getDetail(movieId, apiKey, language)

    fun getMovieVideos(movieId: Int, apiKey: String, language: String) =
        moviesRetrofitService.getVideos(movieId, apiKey, language)
}
