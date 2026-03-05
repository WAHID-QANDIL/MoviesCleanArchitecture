package com.wahid.moviesCleanArchitecture.presentation.ui.screen.allmovies

import com.wahid.moviesCleanArchitecture.domain.model.Movie


sealed class MovieListUiState {
    data object Loading: MovieListUiState()
    data class Success(val movies: List<Movie>): MovieListUiState()
    data class Error(val error: Throwable): MovieListUiState()
}