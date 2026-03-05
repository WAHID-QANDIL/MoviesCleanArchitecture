package com.wahid.moviesCleanArchitecture.presentation.navigation

sealed class ScreenRoutes(val route: String) {
    data object AllMovies : ScreenRoutes("all_movies")
    data object Search : ScreenRoutes("search")
}