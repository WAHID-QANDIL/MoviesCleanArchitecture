package com.wahid.moviesCleanArchitecture.data.local.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.wahid.moviesCleanArchitecture.data.local.database.entity.MovieEntity
import com.wahid.moviesCleanArchitecture.data.model.Movie
import kotlinx.coroutines.flow.Flow


@Dao
interface MovieDao {

    @Upsert
    suspend fun insert(movie: MovieEntity)

    @Upsert
    suspend fun insertAll(movies: List<MovieEntity>)
    @Delete
    suspend fun delete(movie: MovieEntity)

    @Query("SELECT * FROM movies")
    fun getAllMovies(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movies WHERE id = :movieId")
    fun getMovieById(movieId: Int): Flow<MovieEntity>

}