package com.wahid.moviesCleanArchitecture.utils

import com.wahid.moviesCleanArchitecture.MovieApp
import com.wahid.moviesCleanArchitecture.data.local.database.AppDatabase
import com.wahid.moviesCleanArchitecture.data.local.datasource.LocalMovieDatasource
import com.wahid.moviesCleanArchitecture.data.local.datasource.LocalMovieDatasourceImpl
import com.wahid.moviesCleanArchitecture.data.remote.api.RetrofitHelper
import com.wahid.moviesCleanArchitecture.data.remote.datasource.RemoteDataSourceImpl
import com.wahid.moviesCleanArchitecture.data.remote.datasource.RemoteDatasource
import com.wahid.moviesCleanArchitecture.data.repository.MovieRepositoryImpl

object AppDependencyRepo {

    val app: MovieApp by lazy { MovieApp.instance }

    val movieDatabase: AppDatabase by lazy {
        AppDatabase.getInstance(app)
    }

    val remoteDatasource: RemoteDatasource by lazy {
        RemoteDataSourceImpl(movieService = RetrofitHelper.moviesService)
    }

    val localMovieDatasource: LocalMovieDatasource by lazy {
        LocalMovieDatasourceImpl(movieDatabase.getMovieDao())
    }

    val movieRepository by lazy {
        MovieRepositoryImpl(
            remoteDatasource = remoteDatasource,
            localMovieDatasource = localMovieDatasource
        )
    }
}