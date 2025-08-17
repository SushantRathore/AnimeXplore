package com.ssr.animexplore.data.model

import com.google.gson.annotations.SerializedName

/**
 * Represents the response from the top anime API endpoint.
 *
 * This data class encapsulates a list of [AnimeDto] objects, which represent the top anime.
 *
 * @property data A list of [AnimeDto] objects, each representing an anime.
 */
data class TopAnimeResponse(
    val data: List<AnimeDto>
)

/**
 * Data class representing an anime DTO (Data Transfer Object).
 *
 * @property malId The MyAnimeList ID of the anime.
 * @property title The title of the anime.
 * @property images The images associated with the anime.
 * @property trailer The trailer of the anime (nullable).
 * @property synopsis The synopsis of the anime (nullable).
 * @property episodes The number of episodes of the anime (nullable).
 * @property score The score of the anime (nullable).
 * @property genres The list of genres associated with the anime.
 */
data class AnimeDto(
    @SerializedName("mal_id") val malId: Int,
    val title: String,
    val images: Images,
    val trailer: Trailer?,
    val synopsis: String?,
    val episodes: Int?,
    val score: Double?,
    val genres: List<Genre>
)


