package com.ssr.animexplore.data.repository

import android.util.Log
import com.ssr.animexplore.data.local.AnimeDao
import com.ssr.animexplore.data.mapper.toDetailDomain
import com.ssr.animexplore.data.mapper.toDomain
import com.ssr.animexplore.data.mapper.toEntity
import com.ssr.animexplore.data.remote.AnimeApiService
import com.ssr.animexplore.domain.model.Anime
import com.ssr.animexplore.domain.model.AnimeDetail
import com.ssr.animexplore.domain.repository.AnimeRepository

/**
 * Implementation of the [AnimeRepository] interface.
 * This class is responsible for fetching anime data from both the remote API and the local database.
 *
 * @property api The [AnimeApiService] instance for making network requests.
 * @property dao The [AnimeDao] instance for accessing the local database.
 */
class AnimeRepositoryImpl(
    private val api: AnimeApiService,
    private val dao: AnimeDao
) : AnimeRepository {

    /**
     * Retrieves a list of top anime.
     *
     * This function first checks if a refresh is forced or if the local database is empty.
     * If either condition is true, it fetches the top anime from the remote API,
     * logs the response, converts the API response data to entity objects,
     * and inserts them into the local database.
     *
     * Finally, it retrieves all anime from the local database, converts them to domain objects,
     * and returns the list.
     *
     * @param forceRefresh A boolean indicating whether to force a refresh of data from the API,
     *                     even if local data exists. Defaults to false.
     * @return A list of [Anime] objects representing the top anime.
     */
    override suspend fun getTopAnime(forceRefresh: Boolean): List<Anime> {
        if (forceRefresh || dao.getAllAnimeOnce().isEmpty()) {
            val response = api.getTopAnime()
            Log.d("AnimeTop", "Response = $response")
            val entities = response.data.map { it.toEntity() }
            dao.insertAll(entities)
        }
        return dao.getAllAnimeOnce().map { it.toDomain() }
    }

    /**
     * Retrieves detailed information for a specific anime.
     *
     * This function fetches the anime details from the remote API.
     *
     * @param animeId The unique identifier of the anime.
     * @return [AnimeDetail] object containing the detailed information of the anime.
     */
    override suspend fun getAnimeDetail(animeId: Int): AnimeDetail {
        val response = api.getAnimeDetail(animeId)
        Log.d("AnimeDetailRepo", "Response = $response")
        return response.data.toDetailDomain()
    }
}
