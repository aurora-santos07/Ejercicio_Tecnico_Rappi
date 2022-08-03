package com.example.ejerciciotcnicorappi.movies.data.remote

import com.example.ejerciciotcnicorappi.movies.data.UpcomingMoviesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesRetrofitService {

    @GET(EndPointApi.LATEST_LIST)
    fun getLatestList(@Path(ApiPath.API_KEY) apiKey: String) : Single<UpcomingMoviesResponse>
}