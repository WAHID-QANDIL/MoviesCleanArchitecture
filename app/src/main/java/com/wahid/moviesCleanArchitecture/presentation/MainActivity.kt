package com.wahid.moviesCleanArchitecture.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.wahid.moviesCleanArchitecture.presentation.ui.theme.MovieCleanArchitectureTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieCleanArchitectureTheme {
                Scaffold(modifier = Modifier.Companion.fillMaxSize()) {
                    val innerPadding = it

                }
            }
        }
    }
}