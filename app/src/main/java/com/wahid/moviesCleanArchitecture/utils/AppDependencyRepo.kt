package com.wahid.moviesCleanArchitecture.utils

import android.app.Application
import com.wahid.moviesCleanArchitecture.MovieApp
import com.wahid.moviesCleanArchitecture.data.local.database.AppDatabase
import com.wahid.moviesCleanArchitecture.data.local.datasource.LocalMovieDatasource
import com.wahid.moviesCleanArchitecture.data.local.datasource.LocalMovieDatasourceImpl
import com.wahid.moviesCleanArchitecture.data.remote.api.RetrofitHelper
import com.wahid.moviesCleanArchitecture.data.remote.datasource.RemoteDataSourceImpl
import com.wahid.moviesCleanArchitecture.data.remote.datasource.RemoteDatasource
import com.wahid.moviesCleanArchitecture.data.repository.MovieRepositoryImpl

object AppDependencyRepo {
    val application: Application = MovieApp.Companion.application
    val movieDatabase = AppDatabase.Companion.getInstance(application)
    val remoteDatasource: RemoteDatasource =
        RemoteDataSourceImpl(movieService = RetrofitHelper.moviesService)
    val localMovieDatasource: LocalMovieDatasource =
        LocalMovieDatasourceImpl(movieDatabase.getMovieDao())
    val movieRepository = MovieRepositoryImpl(
        remoteDatasource = remoteDatasource,
        localMovieDatasource = localMovieDatasource
    )
}