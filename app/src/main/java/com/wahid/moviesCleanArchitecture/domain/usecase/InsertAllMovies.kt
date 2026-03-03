package com.wahid.moviesCleanArchitecture.domain.usecase

import com.wahid.moviesCleanArchitecture.utils.AppDependencyRepo
import com.wahid.moviesCleanArchitecture.domain.model.Movie
import com.wahid.moviesCleanArchitecture.domain.repository.MovieRepository

class InsertAllMovies(
    val movieRepository: MovieRepository = AppDependencyRepo.movieRepository
) {
    suspend operator fun invoke(movies: List<Movie>) =
        movieRepository.insertAllMovie(movies = movies)
}