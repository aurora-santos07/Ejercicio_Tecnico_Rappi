package com.example.ejerciciotcnicorappi.di

import android.app.Application
import com.example.ejerciciotcnicorappi.App
import com.example.ejerciciotcnicorappi.di.movies.MoviesModule
import com.example.ejerciciotcnicorappi.di.network.NetworkModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, MoviesModule::class])
interface AppComponent {

    fun inject(app: App)

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

}