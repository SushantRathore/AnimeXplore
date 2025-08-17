package com.ssr.animexplore.ui.animedetail

import android.annotation.SuppressLint
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.ssr.animexplore.presentation.AnimeDetailViewModel

const val placeHolderImageUrl = "https://img.youtube.com/vi/ZEkwCGJ3o7M/hqdefault.jpg"

@Composable
fun AnimeDetailScreen(
    viewModel: AnimeDetailViewModel = hiltViewModel()
) {
    val animeDetail by viewModel.animeDetail.collectAsState()

    animeDetail?.let { detail ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {

            if (!detail.trailerUrl.isNullOrEmpty()) {
                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                ) {
                    val width = constraints.maxWidth.toFloat()
                    val height = width /3.5f
                    YouTubePlayer(
                        embedUrl = detail.trailerUrl,
                        modifier = Modifier
                            .height(height.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .verticalScroll(rememberScrollState())
                    )
                }
            } else {
                AsyncImage(
                    model = placeHolderImageUrl,
                    contentDescription = detail.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = detail.title,
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Rating: ${detail.rating ?: "N/A"}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Episodes: ${detail.episodes ?: "?"}",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = detail.synopsis ?: "No synopsis available",
                style = MaterialTheme.typography.bodyMedium
            )

//            Spacer(modifier = Modifier.height(12.dp))

            Spacer(modifier = Modifier.height(16.dp))
        }
    } ?: Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun YouTubePlayer(embedUrl: String, modifier: Modifier = Modifier) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                settings.pluginState = WebSettings.PluginState.ON
                webViewClient = WebViewClient()
                loadUrl(embedUrl)
            }
        }
    )
}
