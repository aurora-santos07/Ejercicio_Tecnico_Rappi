package com.example.ejerciciotcnicorappi.di

import android.app.Application
import android.content.Context
import com.example.ejerciciotcnicorappi.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: App) {

    @Provides
    @Singleton
    fun provideContext(): Context = app


}