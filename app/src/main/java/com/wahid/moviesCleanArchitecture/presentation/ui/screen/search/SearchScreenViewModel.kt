package com.wahid.moviesCleanArchitecture.presentation.ui.screen.search

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.wahid.moviesCleanArchitecture.domain.model.Movie
import com.wahid.moviesCleanArchitecture.domain.usecase.GetAllMovies
import com.wahid.moviesCleanArchitecture.presentation.ui.screen.allmovies.MovieListUiState
import com.wahid.moviesCleanArchitecture.utils.AppDependencyRepo
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@OptIn(FlowPreview::class)
class SearchScreenViewModel(
    private val getAllMovies: GetAllMovies
) : ViewModel() {

    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query.asStateFlow()

    private val _allMovies = MutableStateFlow<List<Movie>>(emptyList())
    private val _isLoaded = MutableStateFlow(false)
    private val _error = MutableStateFlow<Throwable?>(null)

    val uiState: StateFlow<SearchUiState> = combine(
        _query
            .debounce(300)
            .distinctUntilChanged(),
        _allMovies,
        _isLoaded,
        _error
    ) { currentQuery, movies, isLoaded, error ->
        val trimmedQuery = currentQuery.trim()
        when {
            error != null -> SearchUiState.Error(trimmedQuery, error)
            !isLoaded -> SearchUiState.Loading(trimmedQuery)
            else -> {
                val filtered = filterMovies(movies, trimmedQuery)
                if (filtered.isEmpty()) {
                    SearchUiState.Empty(trimmedQuery)
                } else {
                    SearchUiState.Success(trimmedQuery, filtered)
                }
            }
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Lazily,
        initialValue = SearchUiState.Loading("")
    )

    init {
        loadMovies()
    }

    private fun loadMovies() {
        viewModelScope.launch {
            getAllMovies(filters = mapOf(), page = 1)
                .catch { e ->
                    _error.value = e
                }
                .collect { movies ->
                    _allMovies.value = movies
                    _isLoaded.value = true
                }
        }
    }

    fun onQueryChange(newQuery: String) {
        _query.value = newQuery
    }

    private fun filterMovies(movies: List<Movie>, query: String): List<Movie> {
        if (query.isBlank()) return movies

        return movies.filter { movie ->
            movie.title.startsWith(query, ignoreCase = true) ||
                movie.original_title.startsWith(query, ignoreCase = true) ||
                movie.overview.startsWith(query, ignoreCase = true)
        }
    }

    class Factory(
        private val application: Application
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
            if (modelClass.isAssignableFrom(SearchScreenViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return SearchScreenViewModel(
                    getAllMovies = GetAllMovies(movieRepository = AppDependencyRepo.movieRepository)
                ) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class ${modelClass.name}")
        }
    }
}