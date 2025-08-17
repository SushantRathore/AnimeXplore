package com.ssr.animexplore.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents an anime entity in the local database.
 * This class is used by Room to create the "anime_table".
 *
 * @property malId The unique MyAnimeList ID of the anime. This is the primary key.
 * @property title The title of the anime.
 * @property imageUrl The URL of the anime's image.
 * @property score The score of the anime, typically out of 10.
 * @property episodes The number of episodes the anime has. This can be null if the information is not available or if the anime is ongoing.
 */
@Entity(tableName = "anime_table")
data class AnimeEntity(
    @PrimaryKey val malId: Int,
    val title: String,
    val imageUrl: String?,
    val score: Double,
    val episodes: Int?
)


