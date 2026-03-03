package com.wahid.moviesCleanArchitecture.data.remote.api

import com.wahid.mvvm.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {


    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val moviesService: MovieService by lazy {
        retrofit.create(MovieService::class.java)
    }

}