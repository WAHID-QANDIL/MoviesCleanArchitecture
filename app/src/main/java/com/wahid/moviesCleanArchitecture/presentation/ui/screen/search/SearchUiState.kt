package com.wahid.moviesCleanArchitecture.presentation.ui.screen.search

import com.wahid.moviesCleanArchitecture.domain.model.Movie

sealed class SearchUiState {
    data class Loading(val query: String) : SearchUiState()
    data class Success(val query: String, val movies: List<Movie>) : SearchUiState()
    data class Empty(val query: String) : SearchUiState()
    data class Error(val query: String, val error: Throwable) : SearchUiState()
}