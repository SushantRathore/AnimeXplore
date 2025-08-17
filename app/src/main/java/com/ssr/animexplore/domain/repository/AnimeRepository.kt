package com.ssr.animexplore.domain.repository

import com.ssr.animexplore.domain.model.Anime
import com.ssr.animexplore.domain.model.AnimeDetail

/**
 * Interface defining the contract for accessing anime data.
 * This repository provides methods for fetching top anime and detailed information about a specific anime.
 */
interface AnimeRepository {
    suspend fun getTopAnime(forceRefresh: Boolean = false): List<Anime>
    suspend fun getAnimeDetail(animeId: Int): AnimeDetail
}
