package com.wahid.mvvm.data.local.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.wahid.moviesCleanArchitecture.data.model.Movie
import com.wahid.mvvm.data.local.database.entity.MovieEntity
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
    suspend fun getAllMovies(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movies WHERE id = :movieId")
    suspend fun getMovieById(movieId: Int): Movie

}