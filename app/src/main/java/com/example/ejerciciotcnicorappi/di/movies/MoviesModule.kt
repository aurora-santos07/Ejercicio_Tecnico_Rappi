package com.example.ejerciciotcnicorappi.di.movies

import com.example.ejerciciotcnicorappi.movies.data.MoviesRemoteDataSource
import com.example.ejerciciotcnicorappi.movies.data.MoviesRepository
import com.example.ejerciciotcnicorappi.movies.data.remote.MoviesRetrofitService
import com.example.ejerciciotcnicorappi.movies.domain.*
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class MoviesModule {

    @Provides
    @Singleton
    fun provideMoviesRetrofitService(retrofit: Retrofit) =
        retrofit.create(MoviesRetrofitService::class.java)

    @Provides
    @Singleton
    fun provideMoviesRemoteDataSource(retrofitService: MoviesRetrofitService) =
        MoviesRemoteDataSource(retrofitService)

    @Provides
    @Singleton
    fun provideMoviesRepository(moviesRemoteDataSource: MoviesRemoteDataSource) =
        MoviesRepository(moviesRemoteDataSource)

    @Provides
    fun provideGetUpcomingMoviesUseCase(moviesRepository: MoviesRepository) =
        GetUpcomingMoviesUseCase(moviesRepository)

    @Provides
    fun provideGetTopRatedMoviesUseCase(moviesRepository: MoviesRepository) =
        GetTopRatedMoviesUseCase(moviesRepository)

    @Provides
        fun provideRecomendedMoviesUseCase(moviesRepository: MoviesRepository) =
        GetRecomendedMoviesUseCase(moviesRepository)

    @Provides
    fun provideMovieDetailUseCase(moviesRepository: MoviesRepository) =
        GetMovieDetailUseCase(moviesRepository)

    @Provides
    fun provideDiscoverUseCase(moviesRepository: MoviesRepository) =
        GetDiscoverMoviesUseCase(moviesRepository)

    @Provides
    fun provideVideosUseCase(moviesRepository: MoviesRepository) =
        GetMovieVideosUseCase(moviesRepository)
}
