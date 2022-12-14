package com.example.ejerciciotcnicorappi.movies.data.remote

import com.example.ejerciciotcnicorappi.movies.data.MovieDetailResponse
import com.example.ejerciciotcnicorappi.movies.data.MoviesResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesRetrofitService {

    @GET(EndPointApi.UPCOMING_LIST)
    fun getUpcomingList(@Query(ApiPath.API_KEY) apiKey: String,
                        @Query(ApiPath.LANGUAGE) language: String) : Single<MoviesResponse>

    @GET(EndPointApi.TOP_RATED_LIST)
    fun getTopRatedList(@Query(ApiPath.API_KEY) apiKey: String,
                        @Query(ApiPath.LANGUAGE) language: String) : Single<MoviesResponse>

    @GET(EndPointApi.RECOMENDED_LIST)
    fun getRecomendedList(@Path(ApiPath.MOVIE_ID) movieId: Int,
                          @Query(ApiPath.API_KEY) apiKey: String,
                          @Query(ApiPath.LANGUAGE) language: String) : Single<MoviesResponse>

    @GET(EndPointApi.DISCOVER_LIST)
    fun getDiscoverList(@Query(ApiPath.YEAR) year: Int,
                        @Query(ApiPath.API_KEY) apiKey: String,
                        @Query(ApiPath.LANGUAGE) language: String) : Single<MoviesResponse>

    @GET(EndPointApi.MOVIE_DETAIL)
    fun getDetail(@Path(ApiPath.MOVIE_ID) movieId: Int,
                  @Query(ApiPath.API_KEY) apiKey: String,
                  @Query(ApiPath.LANGUAGE) language: String) : Single<MovieDetailResponse>

    @GET(EndPointApi.MOVIE_VIDEOS)
    fun getVideos(@Path(ApiPath.MOVIE_ID) movieId: Int,
                  @Query(ApiPath.API_KEY) apiKey: String,
                  @Query(ApiPath.LANGUAGE) language: String) : Single<MoviesVideoResponse>

}
