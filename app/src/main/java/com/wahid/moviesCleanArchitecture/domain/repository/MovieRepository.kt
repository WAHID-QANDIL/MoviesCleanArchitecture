package com.wahid.moviesCleanArchitecture.domain.repository

import com.wahid.moviesCleanArchitecture.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getAllMovies(
        filters: Map<String, String>,
        page: Int
    ): Flow<List<Movie>>
    suspend fun deleteMovie(movie: Movie)
    suspend fun insertMovie(movie: Movie)
    suspend fun insertAllMovie(movies: List<Movie>)
}