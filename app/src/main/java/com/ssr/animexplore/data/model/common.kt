package com.ssr.animexplore.data.model

import com.google.gson.annotations.SerializedName

/**
 * Represents image URLs for a particular item.
 *
 * @property jpg A [Jpg] object containing the URL for the JPG image.
 */
data class Images(val jpg: Jpg)
data class Jpg(val imageUrl: String)
data class Genre(@SerializedName("mal_id") val malId: Int, val name: String)