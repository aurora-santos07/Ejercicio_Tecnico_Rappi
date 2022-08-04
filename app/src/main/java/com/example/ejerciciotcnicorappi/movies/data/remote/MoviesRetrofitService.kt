package com.example.ejerciciotcnicorappi.movies.data.remote

import com.example.ejerciciotcnicorappi.movies.data.MoviesResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesRetrofitService {

    @GET(EndPointApi.UPCOMING_LIST)
    fun getUpcomingList(@Query(ApiPath.API_KEY) apiKey: String,
                        @Query(ApiPath.LANGUAGE) language: String) : Single<MoviesResponse>

    @GET(EndPointApi.TOP_RATED_LIST)
    fun getTopRatedList(@Query(ApiPath.API_KEY) apiKey: String,
                        @Query(ApiPath.LANGUAGE) language: String) : Single<MoviesResponse>
}