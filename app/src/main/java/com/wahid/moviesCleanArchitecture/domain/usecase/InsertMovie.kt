package com.wahid.moviesCleanArchitecture.domain.usecase

import com.wahid.moviesCleanArchitecture.domain.model.Movie
import com.wahid.moviesCleanArchitecture.domain.repository.MovieRepository

class InsertMovie(
    val movieRepository: MovieRepository
) {

    suspend operator fun invoke(movie: Movie) = movieRepository.insertMovie(movie = movie)
}