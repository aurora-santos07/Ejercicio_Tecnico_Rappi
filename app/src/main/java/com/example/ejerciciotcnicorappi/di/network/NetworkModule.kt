package com.example.ejerciciotcnicorappi.di.network

import com.example.ejerciciotcnicorappi.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideGson()= GsonBuilder().create()

    @Provides
    @Singleton
    fun provideRetrofitBuilder(gson: Gson)= Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())

    @Provides
    @Singleton
    fun provideOkHttpClientBuilder() = OkHttpClient.Builder()
        .readTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))

    @Provides
    @Singleton
    fun provideOkHttpClient(okHttpClientBuilder: OkHttpClient.Builder)= okHttpClientBuilder.build()

    @Provides
    @Singleton
    fun provideRetrofit(retrofitBuilder: Retrofit.Builder, okHttpClient: OkHttpClient) =
        retrofitBuilder.baseUrl(BuildConfig.BASE_URL).client(okHttpClient).build()
}