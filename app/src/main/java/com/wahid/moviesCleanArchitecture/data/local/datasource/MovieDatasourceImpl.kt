package com.wahid.moviesCleanArchitecture.data.local.datasource

import com.wahid.moviesCleanArchitecture.data.local.database.AppDatabase
import com.wahid.moviesCleanArchitecture.data.mapper.movieToEntity
import com.wahid.moviesCleanArchitecture.data.mapper.toDataModel
import com.wahid.moviesCleanArchitecture.data.model.Movie
import com.wahid.mvvm.data.local.database.dao.MovieDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalMovieDatasourceImpl(val movieDao: MovieDao) : LocalMovieDatasource {


    override suspend fun insertMovie(movie: Movie) {
        return movieDao.insert(movie.movieToEntity())
    }

    override suspend fun insertAllMovie(movies: List<Movie>) {
        return movieDao.insertAll(movies.map { it.movieToEntity() })
    }

    override suspend fun deleteMovie(movie: Movie) {
        return movieDao.delete(movie.movieToEntity())
    }

    override suspend fun getAllMovies(): Flow<List<Movie>> {
        return movieDao.getAllMovies().map { list ->
            list.map { entity -> entity.toDataModel() }
        }
    }
}