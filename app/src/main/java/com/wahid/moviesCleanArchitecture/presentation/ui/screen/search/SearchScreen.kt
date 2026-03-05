package com.wahid.moviesCleanArchitecture.presentation.ui.screen.search

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wahid.moviesCleanArchitecture.domain.model.Movie
import com.wahid.moviesCleanArchitecture.presentation.ui.screen.allmovies.MovieItem

@Composable
fun SearchScreen(modifier: Modifier = Modifier) {
    val searchViewModel: SearchScreenViewModel = viewModel(
        factory = SearchScreenViewModel.Factory(
            application = LocalContext.current.applicationContext as android.app.Application
        )
    )
    val uiState by searchViewModel.uiState.collectAsStateWithLifecycle()
    val query by searchViewModel.query.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = query,
            onValueChange = searchViewModel::onQueryChange,
            singleLine = true,
            label = { Text(text = "Search movies") }
        )

        when (val state = uiState) {
            is SearchUiState.Loading -> {
                CircularProgressIndicator()
            }

            is SearchUiState.Error -> {
                Text(
                    text = state.error.message ?: "Something went wrong while searching",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            is SearchUiState.Empty -> {
                val message = if (state.query.isBlank()) {
                    "No movies available"
                } else {
                    "No results for \"${state.query}\""
                }
                Text(
                    text = message,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            is SearchUiState.Success -> {
                SearchResultList(movies = state.movies)
            }
        }
    }
}

@Composable
private fun SearchResultList(movies: List<Movie>) {
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(bottom = 12.dp)
    ) {
        items(movies, key = { it.id }) { movie ->
            MovieItem(
                movie = movie,
                buttonLabel = "Add to Favorites"
            ) {
                Toast.makeText(
                    context,
                    "${movie.title} added to favorites",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}