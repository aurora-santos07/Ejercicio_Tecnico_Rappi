package com.example.ejerciciotcnicorappi.di

import com.example.ejerciciotcnicorappi.App
import com.example.ejerciciotcnicorappi.di.movies.MoviesModule
import com.example.ejerciciotcnicorappi.di.network.NetworkModule
import com.example.ejerciciotcnicorappi.di.viewmodel.ViewModelModule
import com.example.ejerciciotcnicorappi.movies.view.MainActivity
import com.example.ejerciciotcnicorappi.movies.view.fragments.HomeFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,
    NetworkModule::class,
    MoviesModule::class,
    ViewModelModule::class])

interface AppComponent {

    fun inject(app: App)
    fun inject(mainActivity: MainActivity)
    fun inject(homeFragment: HomeFragment)

}