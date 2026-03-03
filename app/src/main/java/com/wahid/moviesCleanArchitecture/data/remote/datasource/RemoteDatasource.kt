package com.wahid.moviesCleanArchitecture.data.remote.datasource

import com.wahid.moviesCleanArchitecture.data.model.Movie
import kotlinx.coroutines.flow.Flow

interface RemoteDatasource {
    suspend fun getAllMovies(
        filters: Map<String, String>,
        page: Int
    ): Flow<List<Movie>>
}