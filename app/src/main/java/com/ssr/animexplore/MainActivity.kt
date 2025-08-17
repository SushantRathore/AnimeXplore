package com.ssr.animexplore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ssr.animexplore.ui.animedetail.AnimeDetailScreen
import com.ssr.animexplore.ui.animelist.AnimeListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "anime_list"
            ) {
                composable("anime_list") {
                    AnimeListScreen { animeId ->
                        navController.navigate("animeDetail/$animeId")
                    }
                }

                composable(
                    route = "animeDetail/{animeId}",
                    arguments = listOf(navArgument("animeId") { type = NavType.IntType })
                ) { backStackEntry ->
                    val animeId = backStackEntry.arguments?.getInt("animeId") ?: 0
                    AnimeDetailScreen()
                }

            }
        }
    }
}