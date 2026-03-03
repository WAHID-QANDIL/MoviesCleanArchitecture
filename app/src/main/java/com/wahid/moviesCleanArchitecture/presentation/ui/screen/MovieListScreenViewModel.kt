package com.wahid.moviesCleanArchitecture.presentation.ui.screen

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.wahid.moviesCleanArchitecture.domain.usecase.GetAllMovies

class MovieListScreenViewModel(
    val getAllMovies: GetAllMovies
): ViewModel() {








    class Factory(
        private val application: Application
    ): ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
            if (modelClass.isAssignableFrom(MovieListScreenViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return MovieListScreenViewModel(getAllMovies = GetAllMovies()) as T
            }else{
                throw IllegalArgumentException("Unknown ViewModel class ${modelClass.name}")
            }
        }
    }
}