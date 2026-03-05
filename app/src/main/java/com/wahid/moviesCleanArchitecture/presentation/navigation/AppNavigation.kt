package com.wahid.moviesCleanArchitecture.presentation.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wahid.moviesCleanArchitecture.presentation.ui.screen.allmovies.MovieListScreen
import com.wahid.moviesCleanArchitecture.presentation.ui.screen.search.SearchScreen

@Composable
fun AppNav(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                navController.navigate(ScreenRoutes.AllMovies.route) {
                    launchSingleTop = true
                }
            }) {
                Text(text = "All Movies")
            }

            Button(onClick = {
                navController.navigate(ScreenRoutes.Search.route) {
                    launchSingleTop = true
                }
            }) {
                Text(text = "Search")
            }
        }
        NavHost(
            navController = navController,
            startDestination = ScreenRoutes.AllMovies.route,
            modifier = Modifier.fillMaxSize()
        ) {
            composable(ScreenRoutes.AllMovies.route) {
                MovieListScreen()
            }
            composable(ScreenRoutes.Search.route) {
                SearchScreen()
            }
        }
    }
}