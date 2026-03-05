package com.wahid.moviesCleanArchitecture.domain.usecase

import com.wahid.moviesCleanArchitecture.domain.model.Movie
import com.wahid.moviesCleanArchitecture.domain.repository.MovieRepository

class DeleteMovie(val movieRepository: MovieRepository) {
    suspend operator fun invoke(movie: Movie) = movieRepository.deleteMovie(movie = movie)
}