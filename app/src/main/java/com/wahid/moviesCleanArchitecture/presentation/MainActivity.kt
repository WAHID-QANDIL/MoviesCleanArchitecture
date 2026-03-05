package com.wahid.moviesCleanArchitecture.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.wahid.moviesCleanArchitecture.presentation.navigation.AppNav
import com.wahid.moviesCleanArchitecture.presentation.ui.theme.MovieCleanArchitectureTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieCleanArchitectureTheme {
                AppNav(modifier = Modifier.fillMaxSize())
            }
        }
    }
}