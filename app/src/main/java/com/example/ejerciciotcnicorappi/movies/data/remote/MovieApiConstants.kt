package com.example.ejerciciotcnicorappi.movies.data.remote

import com.example.ejerciciotcnicorappi.movies.data.remote.ApiMethods.MOVIE
import com.example.ejerciciotcnicorappi.movies.data.remote.ApiMethods.RECOMENDATIONS
import com.example.ejerciciotcnicorappi.movies.data.remote.ApiMethods.TOP_RATED
import com.example.ejerciciotcnicorappi.movies.data.remote.ApiMethods.UPCOMING
import com.example.ejerciciotcnicorappi.movies.data.remote.ApiPath.MOVIE_ID

object EndPointApi {
    const val TOP_RATED_LIST = "$MOVIE$TOP_RATED/"
    const val UPCOMING_LIST = "$MOVIE$UPCOMING/"
    const val RECOMENDED_LIST = "$MOVIE{$MOVIE_ID}/$RECOMENDATIONS"
    const val MOVIE_DETAIL = "$MOVIE{$MOVIE_ID}"
}

object ApiMethods{
    const val MOVIE = "movie/"
    const val UPCOMING = "upcoming"
    const val TOP_RATED = "top_rated"
    const val RECOMENDATIONS = "recommendations"
}

object ApiPath {
    const val API_KEY = "api_key"
    const val LANGUAGE = "language"
    const val MOVIE_ID = "movie_id"
}