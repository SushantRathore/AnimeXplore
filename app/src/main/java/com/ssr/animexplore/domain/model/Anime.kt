package com.ssr.animexplore.domain.model

/**
 * Represents an anime.
 *
 * @property id The unique identifier of the anime.
 * @property title The title of the anime.
 * @property episodes The number of episodes in the anime. Can be null if unknown.
 * @property score The score of the anime. Can be null if unknown.
 * @property imageUrl The URL of the anime's image.
 */
data class Anime(
    val id: Int,
    val title: String,
    val episodes: Int?,
    val score: Double?,
    val imageUrl: String?
)
