package com.example.ejerciciotcnicorappi.movies.data.remote

import com.example.ejerciciotcnicorappi.movies.data.remote.ApiMethods.LATEST
import com.example.ejerciciotcnicorappi.movies.data.remote.ApiMethods.MOVIE

object EndPointApi {
    const val LATEST_LIST = "$MOVIE$LATEST/{api_key}"
}

object ApiMethods{
    const val MOVIE = "movie/"
    const val LATEST = "latest"
    const val TOP_RATED = "top_rated"
    const val RECOMENDATIONS = "recommendations"
}

object ApiPath {
    const val API_KEY = "api_key"
}