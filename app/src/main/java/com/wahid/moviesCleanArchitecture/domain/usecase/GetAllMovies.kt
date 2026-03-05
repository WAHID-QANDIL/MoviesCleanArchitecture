package com.wahid.moviesCleanArchitecture.domain.usecase

import com.wahid.moviesCleanArchitecture.domain.repository.MovieRepository

class GetAllMovies(val movieRepository: MovieRepository) {
    operator fun invoke(filters: Map<String, String>, page: Int) =
        movieRepository.getAllMovies(filters = filters, page = page)
}