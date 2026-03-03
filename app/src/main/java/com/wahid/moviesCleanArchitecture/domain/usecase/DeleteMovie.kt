package com.wahid.moviesCleanArchitecture.domain.usecase

import com.wahid.moviesCleanArchitecture.utils.AppDependencyRepo
import com.wahid.moviesCleanArchitecture.domain.model.Movie
import com.wahid.moviesCleanArchitecture.domain.repository.MovieRepository

class DeleteMovie(val movieRepository: MovieRepository = AppDependencyRepo.movieRepository) {
    suspend operator fun invoke(movie: Movie) = movieRepository.deleteMovie(movie = movie)
}