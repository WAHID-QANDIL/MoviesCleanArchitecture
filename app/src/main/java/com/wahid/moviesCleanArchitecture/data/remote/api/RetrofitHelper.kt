package com.wahid.moviesCleanArchitecture.data.remote.api

import com.wahid.mvvm.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitHelper {
    const val REQUEST_TIME_OUT = 5L

    val okHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor { chain ->
            val originalRequest = chain.request()
            val newRequest = originalRequest
                .newBuilder()
                .header("Authorization", "Bearer ${BuildConfig.BEARER_ACCESS_TOKEN}")
                .build()
            chain.proceed(newRequest)
        }
        .readTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
        .writeTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
        .connectTimeout(REQUEST_TIME_OUT, TimeUnit.SECONDS)
        .build()

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val moviesService: MovieService by lazy {
        retrofit.create(MovieService::class.java)
    }

}