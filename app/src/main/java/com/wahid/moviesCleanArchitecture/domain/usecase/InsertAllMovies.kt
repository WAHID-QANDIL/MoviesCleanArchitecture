package com.wahid.moviesCleanArchitecture.domain.usecase

import com.wahid.moviesCleanArchitecture.domain.model.Movie
import com.wahid.moviesCleanArchitecture.domain.repository.MovieRepository

class InsertAllMovies(
    val movieRepository: MovieRepository
) {
    suspend operator fun invoke(movies: List<Movie>) =
        movieRepository.insertAllMovie(movies = movies)
}