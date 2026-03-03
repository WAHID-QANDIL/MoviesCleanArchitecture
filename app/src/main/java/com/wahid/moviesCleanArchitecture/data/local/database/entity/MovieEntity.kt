package com.wahid.mvvm.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieEntity(
    @ColumnInfo(name = "id") @PrimaryKey val id: Int,
    @ColumnInfo(name = "title")             val title: String,
    @ColumnInfo(name = "poster_path")       val poster_path: String,
    @ColumnInfo(name = "backdrop_path")     val backdrop_path: String,
    @ColumnInfo(name = "original language") val original_language: String,
    @ColumnInfo(name = "original title")    val original_title: String,
    @ColumnInfo(name = "overview")          val overview: String,
    @ColumnInfo(name = "adult")             val adult: Boolean,
    @ColumnInfo(name = "video")             val video: Boolean,
    @ColumnInfo(name = "popularity")        val popularity: Double,
    @ColumnInfo(name = "genre_ids")         val genre_ids: List<Int>,
    @ColumnInfo(name = "release_date")      val release_date: String,
    @ColumnInfo(name = "vote_average")      val vote_average: Double,
    @ColumnInfo(name = "vote_count")        val vote_count: Int
)
