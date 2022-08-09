package com.example.ejerciciotcnicorappi.movies.data.remote

import com.example.ejerciciotcnicorappi.movies.data.remote.ApiMethods.DISCOVER
import com.example.ejerciciotcnicorappi.movies.data.remote.ApiMethods.MOVIE
import com.example.ejerciciotcnicorappi.movies.data.remote.ApiMethods.RECOMENDATIONS
import com.example.ejerciciotcnicorappi.movies.data.remote.ApiMethods.TOP_RATED
import com.example.ejerciciotcnicorappi.movies.data.remote.ApiMethods.UPCOMING
import com.example.ejerciciotcnicorappi.movies.data.remote.ApiMethods.VIDEOS
import com.example.ejerciciotcnicorappi.movies.data.remote.ApiPath.MOVIE_ID

object EndPointApi {
    const val TOP_RATED_LIST = "$MOVIE/$TOP_RATED"
    const val UPCOMING_LIST = "$MOVIE/$UPCOMING"
    const val RECOMENDED_LIST = "$MOVIE/{$MOVIE_ID}/$RECOMENDATIONS"
    const val DISCOVER_LIST = "$DISCOVER$MOVIE"
    const val MOVIE_DETAIL = "$MOVIE/{$MOVIE_ID}"
    const val MOVIE_VIDEOS = "$MOVIE/{$MOVIE_ID}/$VIDEOS"
}

object ApiMethods{
    const val MOVIE = "movie"
    const val UPCOMING = "upcoming"
    const val TOP_RATED = "top_rated"
    const val RECOMENDATIONS = "recommendations"
    const val DISCOVER = "discover/"
    const val VIDEOS = "videos"
}

object ApiPath {
    const val API_KEY = "api_key"
    const val LANGUAGE = "language"
    const val MOVIE_ID = "movie_id"
    const val YEAR = "year"
}