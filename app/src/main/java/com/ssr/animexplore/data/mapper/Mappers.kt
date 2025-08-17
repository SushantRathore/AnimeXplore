package com.ssr.animexplore.data.mapper

import com.ssr.animexplore.data.local.AnimeEntity
import com.ssr.animexplore.data.model.AnimeDetailDto
import com.ssr.animexplore.data.model.AnimeDto
import com.ssr.animexplore.domain.model.Anime
import com.ssr.animexplore.domain.model.AnimeDetail


/**
 * Converts an [AnimeDto] to an [AnimeEntity].
 *
 * This function maps the data transfer object (DTO) representation of an anime
 * to its corresponding database entity representation.
 *
 * @return The [AnimeEntity] representation of the [AnimeDto].
 */
fun AnimeDto.toEntity(): AnimeEntity {
    return AnimeEntity(
        malId = malId,
        title = title,
        imageUrl = images?.jpg?.imageUrl,
        score = score ?: 0.0,
        episodes = episodes
    )
}

/**
 * Converts an [AnimeEntity] to an [Anime] domain model.
 *
 * This function maps the properties of an [AnimeEntity] from the data layer
 * to the corresponding properties of an [Anime] model in the domain layer.
 *
 * @return An [Anime] object representing the domain model of the anime.
 */
fun AnimeEntity.toDomain(): Anime {
    return Anime(
        id = malId,
        title = title,
        imageUrl = imageUrl,
        score = score,
        episodes = episodes
    )
}

/**
 * Converts an [AnimeDetailDto] to an [AnimeDetail] domain model.
 *
 * This function maps the data transfer object (DTO) received from the API
 * to a domain model suitable for use in the application's business logic.
 * It handles potential null values by providing default values.
 * For example, if `images?.jpg?.imageUrl` is null, it defaults to a placeholder image URL.
 * Similarly, if `synopsis` is null, it defaults to "No synopsis available".
 * The `cast` is initialized as an empty list because character information
 * is fetched from a separate API endpoint.
 *
 * @return [AnimeDetail] The domain model representation of the anime details.
 */
fun AnimeDetailDto.toDetailDomain(): AnimeDetail {
    return AnimeDetail(
        id = malId,
        title = title,
        imageUrl = images?.jpg?.imageUrl.toString(),
        synopsis = synopsis ?: "No synopsis available",
        trailerUrl = trailer?.url,
        genres = genres.map { it.name },
        cast = emptyList(), // characters are fetched from a separate endpoint
        episodes = episodes ?: 0,
        rating = score ?: 0.0
    )
}
