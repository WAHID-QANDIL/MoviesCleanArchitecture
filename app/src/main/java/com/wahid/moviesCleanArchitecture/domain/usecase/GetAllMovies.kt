package com.wahid.moviesCleanArchitecture.domain.usecase

import com.wahid.moviesCleanArchitecture.utils.AppDependencyRepo
import com.wahid.moviesCleanArchitecture.domain.repository.MovieRepository

class GetAllMovies(val movieRepository: MovieRepository = AppDependencyRepo.movieRepository) {
    suspend operator fun invoke(filters: Map<String, String>, page: Int) =
        movieRepository.getAllMovies(filters = filters, page = page)
}