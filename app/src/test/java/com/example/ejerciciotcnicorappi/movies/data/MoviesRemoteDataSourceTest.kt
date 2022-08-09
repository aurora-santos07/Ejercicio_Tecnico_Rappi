package com.example.ejerciciotcnicorappi.movies.data

import com.example.ejerciciotcnicorappi.BuildConfig
import com.example.ejerciciotcnicorappi.movies.data.remote.MoviesRetrofitService
import com.example.ejerciciotcnicorappi.movies.domain.DEFAULT_LANGUAGE
import com.example.ejerciciotcnicorappi.testutils.MockWebServerRule
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.junit.MockitoJUnit
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

class MoviesRemoteDataSourceTest{

    @Rule @JvmField val mockitoRule = MockitoJUnit.rule()
    @Rule @JvmField val mockitoWebServerRule = MockWebServerRule()

    private lateinit var moviesRemoteDataSource: MoviesRemoteDataSource

    @Before
    fun setup(){
        val moviesRetrofitService = Retrofit.Builder()
            .baseUrl(mockitoWebServerRule.getBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.createSynchronous())
            .client(OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build())
            .build()
            .create(MoviesRetrofitService::class.java)

        moviesRemoteDataSource = MoviesRemoteDataSource(moviesRetrofitService)
    }

    @Test
    fun sendGetUpcommingRequest(){
        mockitoWebServerRule.givenMockitoResponse(json = "data/upcomingMoviesResponse.json")
        val response = moviesRemoteDataSource.getUpcomingMoviesList(APP_KEY_F, LANGUAGE_F).test().assertNoErrors()
            .values()[0]
        assertUpcommingMoviesResponse(response)
    }

    @Test
    fun sendGetDetailRequest(){
        mockitoWebServerRule.givenMockitoResponse(json = "data/detailMovieResponse.json")
        val response = moviesRemoteDataSource.getMovieDetail(ID_MOVIE_F, APP_KEY_F, LANGUAGE_F).test().assertNoErrors()
            .values()[0]
        assertMovieDetailResponse(response)
    }

    @Test
    fun sendGetVideosRequest(){
        mockitoWebServerRule.givenMockitoResponse(json = "data/videosMovieResponse.json")
        val response = moviesRemoteDataSource.getMovieVideos(ID_MOVIE_F, APP_KEY_F, LANGUAGE_F).test().assertNoErrors()
            .values()[0]
        assertVideosMovieResponse(response)
    }

    @Test
    fun sendMovieUpcommingToCorrectEndpoint(){
        mockitoWebServerRule.givenMockitoResponse()
        moviesRemoteDataSource.getUpcomingMoviesList(APP_KEY_F, LANGUAGE_F).test()
        mockitoWebServerRule.server.takeRequest().run {
            MatcherAssert.assertThat(path, CoreMatchers.equalTo("/movie/upcoming?api_key=$APP_KEY_F&language=$LANGUAGE_F"))
            MatcherAssert.assertThat(method, CoreMatchers.equalTo("GET"))
        }
    }

    @Test
    fun sendDetailToCorrectEndpoint(){
        mockitoWebServerRule.givenMockitoResponse()
        moviesRemoteDataSource.getMovieDetail(ID_MOVIE_F, APP_KEY_F, LANGUAGE_F).test()
        mockitoWebServerRule.server.takeRequest().run {
            MatcherAssert.assertThat(path, CoreMatchers.equalTo("/movie/$ID_MOVIE_F?api_key=$APP_KEY_F&language=$LANGUAGE_F"))
            MatcherAssert.assertThat(method, CoreMatchers.equalTo("GET"))
        }
    }

    @Test
    fun sendVideoToCorrectEndpoint(){
        mockitoWebServerRule.givenMockitoResponse()
        moviesRemoteDataSource.getMovieVideos(VIDEOS_ID_MOVIE_F, APP_KEY_F, LANGUAGE_F).test()
        mockitoWebServerRule.server.takeRequest().run {
            MatcherAssert.assertThat(path, CoreMatchers.equalTo("/movie/$VIDEOS_ID_MOVIE_F/videos?api_key=$APP_KEY_F&language=$LANGUAGE_F"))
            MatcherAssert.assertThat(method, CoreMatchers.equalTo("GET"))
        }
    }

    @Test
    fun sendTopRatedToCorrectEndpoint(){
        mockitoWebServerRule.givenMockitoResponse()
        moviesRemoteDataSource.getTopRatedMoviesList(APP_KEY_F, LANGUAGE_F).test()
        mockitoWebServerRule.server.takeRequest().run {
            MatcherAssert.assertThat(path, CoreMatchers.equalTo("/movie/top_rated?api_key=$APP_KEY_F&language=$LANGUAGE_F"))
            MatcherAssert.assertThat(method, CoreMatchers.equalTo("GET"))
        }
    }

    @Test
    fun sendDiscoverToCorrectEndpoint(){
        mockitoWebServerRule.givenMockitoResponse()
        moviesRemoteDataSource.getDiscoverList(YEAR_F, APP_KEY_F, LANGUAGE_F).test()
        mockitoWebServerRule.server.takeRequest().run {
            MatcherAssert.assertThat(path, CoreMatchers.equalTo("/discover/movie?year=$YEAR_F&api_key=$APP_KEY_F&language=$LANGUAGE_F"))
            MatcherAssert.assertThat(method, CoreMatchers.equalTo("GET"))
        }
    }

}
