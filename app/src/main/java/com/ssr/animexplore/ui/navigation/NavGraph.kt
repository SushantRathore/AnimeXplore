package com.ssr.animexplore.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ssr.animexplore.ui.animedetail.AnimeDetailScreen
import com.ssr.animexplore.ui.animelist.AnimeListScreen
import com.ssr.animexplore.ui.navigation.AppDestinations.ANIME_DETAIL_ID_KEY
import com.ssr.animexplore.ui.navigation.AppDestinations.ANIME_DETAIL_ROUTE
import com.ssr.animexplore.ui.navigation.AppDestinations.ANIME_DETAIL_WITH_ARG_ROUTE
import com.ssr.animexplore.ui.navigation.AppDestinations.ANIME_LIST_ROUTE

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ANIME_LIST_ROUTE
    ) {
        composable(ANIME_LIST_ROUTE) {
            AnimeListScreen { animeId ->
                navController.navigate("${ANIME_DETAIL_ROUTE}/$animeId")
            }
        }

        composable(
            route = ANIME_DETAIL_WITH_ARG_ROUTE,
            arguments = listOf(navArgument(ANIME_DETAIL_ID_KEY) {
                type = NavType.IntType
            })
        ) {
            AnimeDetailScreen()
        }
    }
}
