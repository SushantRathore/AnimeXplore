package com.ssr.animexplore.ui.animelist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ssr.animexplore.presentation.AnimeListViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimeListScreen(
    viewModel: AnimeListViewModel = hiltViewModel(),
    onAnimeClick: (Int) -> Unit
) {
    val animeList by viewModel.animeList.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("AnimeXplorer") },
            )
        }
    ) { paddingValues ->
        if (animeList.isEmpty()) {
            // Show loader while fetching
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                androidx.compose.material3.CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                items(animeList) { anime ->
                    AnimeListItem(
                        anime = anime,
                        index = animeList.indexOf(anime),
                        onClick = { onAnimeClick(anime.id) }
                    )
                }
            }
        }
    }
}
