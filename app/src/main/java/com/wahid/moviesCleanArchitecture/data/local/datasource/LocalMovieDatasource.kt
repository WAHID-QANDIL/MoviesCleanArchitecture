package com.wahid.moviesCleanArchitecture.data.local.datasource

import com.wahid.moviesCleanArchitecture.data.model.Movie
import kotlinx.coroutines.flow.Flow


interface LocalMovieDatasource {

    suspend fun insertMovie(movie: Movie)
    suspend fun insertAllMovie(movies: List<Movie>)
    suspend fun deleteMovie(movie: Movie)
    fun getAllMovies(): Flow<List<Movie>>


}