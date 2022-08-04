package com.example.ejerciciotcnicorappi.di.viewmodel

import androidx.lifecycle.ViewModel
import com.example.ejerciciotcnicorappi.di.scopes.ViewModelKey
import com.example.ejerciciotcnicorappi.movies.view.viewModel.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelFactoryModule::class])
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel
}