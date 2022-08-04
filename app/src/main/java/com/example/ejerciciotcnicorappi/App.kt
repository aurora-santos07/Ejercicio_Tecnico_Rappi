package com.example.ejerciciotcnicorappi

import android.app.Application
import com.example.ejerciciotcnicorappi.di.AppComponent
import com.example.ejerciciotcnicorappi.di.AppModule
import com.example.ejerciciotcnicorappi.di.DaggerAppComponent

class App: Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        setupDependencies()
    }

    fun setupDependencies(){
        component = DaggerAppComponent.builder().appModule(
            AppModule(this)
        ).build()
    }


    companion object {
        lateinit var instance: App private set


    }
}