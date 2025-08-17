package com.ssr.animexplore.data.model

import com.google.gson.annotations.SerializedName

/**
 * Represents the top-level response structure when fetching detailed information for a specific anime.
 *
 * This class encapsulates the actual anime detail data within its `data` property.
 * It's typically used as the direct deserialization target for API responses
 * that provide anime details.
 *
 * @property data The core [AnimeDetailDto] object containing all the detailed information about the anime.
 */
data class AnimeDetailResponse(
    val data: AnimeDetailDto
)

/**
 * Data class representing the detailed information of an anime.
 *
 * @property malId The MyAnimeList ID of the anime.
 * @property title The primary title of the anime.
 * @property titleEnglish The English title of the anime, if available.
 * @property titleJapanese The Japanese title of the anime, if available.
 * @property synopsis A brief summary or plot of the anime.
 * @property episodes The total number of episodes in the anime.
 * @property score The average user score for the anime.
 * @property images An object containing URLs for different image versions of the anime.
 * @property trailer An object containing information about the anime's trailer.
 * @property genres A list of genres associated with the anime.
 * @property status The current airing status of the anime (e.g., "Finished Airing", "Currently Airing").
 * @property rating The age rating of the anime (e.g., "PG-13 - Teens 13 or older").
 * @property year The year the anime was first released.
 * @property duration The duration of each episode.
 */
data class AnimeDetailDto(
    @SerializedName("mal_id") val malId: Int,
    val title: String,
    @SerializedName("title_english") val titleEnglish: String?,
    @SerializedName("title_japanese") val titleJapanese: String?,
    val synopsis: String?,
    val episodes: Int?,
    val score: Double?,
    val images: Images,
    val trailer: Trailer?,
    val genres: List<Genre>,
    val status: String?,
    val rating: String?,
    val year: Int?,
    val duration: String?
)

/**
 * Represents trailer information for an anime.
 *
 * @property url The URL of the trailer.
 * @property youtubeId The YouTube ID of the trailer.
 * @property embedUrl The embed URL for the trailer.
 */
data class Trailer(
    val url: String?,
    @SerializedName("youtube_id") val youtubeId: String?,
    @SerializedName("embed_url") val embedUrl: String?
)

