package com.wahid.moviesCleanArchitecture.data.mapper

import com.wahid.moviesCleanArchitecture.data.model.Movie
import com.wahid.moviesCleanArchitecture.data.remote.dto.MovieRemoteModel
import com.wahid.mvvm.data.local.database.entity.MovieEntity


fun Movie.movieToEntity() = MovieEntity(
    id = id,
    title = title,
    poster_path = poster_path,
    backdrop_path = backdrop_path,
    original_language = original_language,
    original_title = original_title,
    overview = overview,
    adult = adult,
    video = video,
    popularity = popularity,
    genre_ids = genre_ids,
    release_date = release_date,
    vote_average = vote_average,
    vote_count = vote_count,
)



fun com.wahid.moviesCleanArchitecture.domain.model.Movie.movieToDataModel() = Movie(
    id = id,
    title = title,
    poster_path = poster_path,
    backdrop_path = backdrop_path,
    original_language = original_language,
    original_title = original_title,
    overview = overview,
    adult = adult,
    video = video,
    popularity = popularity,
    genre_ids = genre_ids,
    release_date = release_date,
    vote_average = vote_average,
    vote_count = vote_count,
)

fun Movie.movieToDomainModel() = com.wahid.moviesCleanArchitecture.domain.model.Movie(
    id = id,
    title = title,
    poster_path = poster_path,
    backdrop_path = backdrop_path,
    original_language = original_language,
    original_title = original_title,
    overview = overview,
    adult = adult,
    video = video,
    popularity = popularity,
    genre_ids = genre_ids,
    release_date = release_date,
    vote_average = vote_average,
    vote_count = vote_count,
)


fun MovieEntity.toDataModel() = Movie(
    id = id,
    title = title,
    poster_path = poster_path,
    backdrop_path = backdrop_path,
    original_language = original_language,
    original_title = original_title,
    overview = overview,
    adult = adult,
    video = video,
    popularity = popularity,
    genre_ids = genre_ids,
    release_date = release_date,
    vote_average = vote_average,
    vote_count = vote_count,
)

fun MovieRemoteModel.toDataModel() = Movie(
    id = id,
    title = title,
    poster_path = posterPath,
    backdrop_path = backdropPath ?: "",
    original_language = originalLanguage,
    original_title = originalTitle,
    overview = overview,
    adult = adult,
    video = video,
    popularity = popularity,
    genre_ids = genreIds,
    release_date = releaseDate,
    vote_average = voteAverage,
    vote_count = voteCount,
)