package com.wahid.moviesCleanArchitecture.data.local.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.wahid.mvvm.data.local.database.dao.MovieDao
import com.wahid.mvvm.data.local.database.entity.MovieEntity


@Database(entities = [MovieEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getMovieDao(): MovieDao
    companion object{
        private lateinit var INSTANCE: AppDatabase

        fun getInstance(application: Application): AppDatabase = INSTANCE ?: synchronized(this){
            val instance = Room.databaseBuilder(application, AppDatabase::class.java,"movie_db").build()
            INSTANCE = instance
            INSTANCE
        }
    }
}