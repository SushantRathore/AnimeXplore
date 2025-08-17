package com.ssr.animexplore.data.remote

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Dagger Hilt module for providing network-related dependencies.
 *
 * This module is installed in the [SingletonComponent], meaning the provided
 * dependencies will have a singleton scope throughout the application.
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    /**
     * Provides a singleton instance of [Retrofit].
     *
     * This Retrofit instance is configured with:
     * - Base URL: "https://api.jikan.moe/v4/"
     * - Converter Factory: [GsonConverterFactory] for JSON serialization/deserialization.
     *
     * @return A configured [Retrofit] instance.
     */
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/v4/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /**
     * Provides a singleton instance of [AnimeApiService].
     *
     * This function uses the provided [Retrofit] instance to create an implementation
     * of the [AnimeApiService] interface. This service will be used to make API calls
     * to the Jikan API for anime-related data.
     *
     * @param retrofit The Retrofit instance to use for creating the API service.
     * @return A singleton instance of [AnimeApiService].
     */
    @Provides
    @Singleton
    fun provideAnimeApi(retrofit: Retrofit): AnimeApiService {
        return retrofit.create(AnimeApiService::class.java)
    }
}
