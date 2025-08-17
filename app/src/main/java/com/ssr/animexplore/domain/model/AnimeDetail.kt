package com.ssr.animexplore.domain.model

/**
 * Represents detailed information about an anime.
 *
 * @property trailerUrl The URL of the anime's trailer, if available.
 * @property imageUrl The URL of the anime's image.
 * @property title The title of the anime.
 * @property synopsis A brief summary of the anime's plot.
 * @property genres A list of genres the anime belongs to.
 * @property cast A list of main cast members or voice actors.
 * @property episodes The total number of episodes in the anime.
 * @property rating The average rating of the anime.
 * @property id The unique identifier for the anime.
 */
data class AnimeDetail(
    val trailerUrl: String?,
    val imageUrl: String,
    val title: String,
    val synopsis: String,
    val genres: List<String>,
    val cast: List<String>,
    val episodes: Int,
    val rating: Double,
    val id: Int
)