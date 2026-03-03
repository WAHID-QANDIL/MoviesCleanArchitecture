package com.wahid.moviesCleanArchitecture.data.remote.datasource

import com.wahid.moviesCleanArchitecture.data.mapper.toDataModel
import com.wahid.moviesCleanArchitecture.data.model.Movie
import com.wahid.moviesCleanArchitecture.data.remote.api.MovieService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSourceImpl(val movieService: MovieService) : RemoteDatasource {
    override suspend fun getAllMovies(
        filters: Map<String, String>,
        page: Int
    ): Flow<List<Movie>> = flow {
        runCatching {
            movieService.getAllMovies(
                filters, page
            )
        }.onSuccess { response ->
            response.body()?.results?.forEach { it.toDataModel() }
        }.onFailure { error->
            throw error
        }
    }
}