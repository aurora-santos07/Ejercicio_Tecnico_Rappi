package com.example.ejerciciotcnicorappi.di

import android.app.Application
import android.content.Context
import com.example.ejerciciotcnicorappi.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(app: App) {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application


}