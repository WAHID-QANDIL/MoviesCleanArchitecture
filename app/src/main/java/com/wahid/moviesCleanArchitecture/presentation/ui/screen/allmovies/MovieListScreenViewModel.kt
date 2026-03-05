package com.wahid.moviesCleanArchitecture.presentation.ui.screen.allmovies

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.wahid.moviesCleanArchitecture.domain.usecase.GetAllMovies
import com.wahid.moviesCleanArchitecture.utils.AppDependencyRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class MovieListScreenViewModel(
    val getAllMovies: GetAllMovies
) : ViewModel() {

    private val _moviesState = MutableStateFlow<MovieListUiState>(MovieListUiState.Loading)
    val moviesState: StateFlow<MovieListUiState> = _moviesState

    init {
        viewModelScope.launch {
            getAllMovies(
                mapOf(),
                1
            ).catch {
                _moviesState.value = MovieListUiState.Error(it)
            }.collect { movies ->
                _moviesState.value = MovieListUiState.Success(movies)
            }
        }
    }


    class Factory(
        private val application: Context
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
            if (modelClass.isAssignableFrom(MovieListScreenViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MovieListScreenViewModel(
                    getAllMovies = GetAllMovies(movieRepository = AppDependencyRepo.movieRepository)
                ) as T
            } else {
                throw IllegalArgumentException("Unknown ViewModel class ${modelClass.name}")
            }
        }
    }
}