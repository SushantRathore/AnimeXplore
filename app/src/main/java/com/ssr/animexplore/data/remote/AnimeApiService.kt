package com.ssr.animexplore.data.remote

import com.ssr.animexplore.data.model.AnimeDetailResponse
import com.ssr.animexplore.data.model.TopAnimeResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Interface defining the API endpoints for fetching anime data.
 * This interface is used by Retrofit to generate the network request implementations.
 */
interface AnimeApiService {
    @GET("top/anime")
    suspend fun getTopAnime(): TopAnimeResponse

    @GET("anime/{id}/full")
    suspend fun getAnimeDetail(@Path("id") animeId: Int): AnimeDetailResponse
}
