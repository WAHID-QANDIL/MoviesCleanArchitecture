package com.wahid.moviesCleanArchitecture.data.repository

import com.wahid.moviesCleanArchitecture.data.local.datasource.LocalMovieDatasource
import com.wahid.moviesCleanArchitecture.data.mapper.movieToDataModel
import com.wahid.moviesCleanArchitecture.data.mapper.movieToDomainModel
import com.wahid.moviesCleanArchitecture.data.remote.datasource.RemoteDatasource
import com.wahid.moviesCleanArchitecture.domain.model.Movie
import com.wahid.moviesCleanArchitecture.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList

class MovieRepositoryImpl(
    val remoteDatasource: RemoteDatasource,
    val localMovieDatasource: LocalMovieDatasource
) : MovieRepository {
    override suspend fun getAllMovies(
        filters: Map<String, String>,
        page: Int
    ): Flow<List<Movie>> {
        /*
        * Here we can make logic for fetching from local datasource(DB) or from the API*/
        val movies = remoteDatasource.getAllMovies(
            filters = filters,
            page = page
        )
        val entities = movies.toList().flatten()
        localMovieDatasource.insertAllMovie(entities)


        return localMovieDatasource.getAllMovies().map {
            it.map { movie -> movie.movieToDomainModel() }
        }


    }

    override suspend fun deleteMovie(movie: Movie) {
        localMovieDatasource.deleteMovie(movie = movie.movieToDataModel())
    }

    override suspend fun insertMovie(movie: Movie) {
        localMovieDatasource.insertMovie(movie = movie.movieToDataModel())
    }

    override suspend fun insertAllMovie(movies: List<Movie>) {
        localMovieDatasource.insertAllMovie(movies = movies.map { it.movieToDataModel() })
    }
}