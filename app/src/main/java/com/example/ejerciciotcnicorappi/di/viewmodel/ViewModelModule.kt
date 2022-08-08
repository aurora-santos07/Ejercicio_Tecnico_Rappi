package com.example.ejerciciotcnicorappi.di.viewmodel

import androidx.lifecycle.ViewModel
import com.example.ejerciciotcnicorappi.di.scopes.ViewModelKey
import com.example.ejerciciotcnicorappi.movies.view.viewModel.HomeViewModel
import com.example.ejerciciotcnicorappi.movies.view.viewModel.MovieDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelFactoryModule::class])
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailViewModel::class)
    abstract fun bindMovieDetailViewModel(movieDetailViewModel: MovieDetailViewModel): ViewModel
}