package com.example.movieticketsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieticketsapp.screens.HomeScreen
import com.example.movieticketsapp.screens.MovieDetailsScreen
import com.example.movieticketsapp.screens.booking_screen.BookingScreen
import com.example.movieticketsapp.ui.theme.MovieTicketsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieTicketsAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "homeScreen") {
                    composable("homeScreen") { HomeScreen(navController) }
                    composable("movieDetails") { MovieDetailsScreen(navController) }
                    composable("booking") { BookingScreen(navController = navController) }
                }
            }
        }
    }
}

