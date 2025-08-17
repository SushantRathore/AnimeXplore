package com.ssr.animexplore.di

import android.content.Context
import androidx.room.Room
import com.ssr.animexplore.data.local.AnimeDao
import com.ssr.animexplore.data.local.AppDatabase
import com.ssr.animexplore.data.remote.AnimeApiService
import com.ssr.animexplore.data.repository.AnimeRepositoryImpl
import com.ssr.animexplore.domain.repository.AnimeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dagger Hilt module that provides dependencies for the application.
 * This module is installed in the [SingletonComponent], meaning the provided dependencies
 * will have a singleton scope and live as long as the application.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    /**
     * Provides a singleton instance of the Room database.
     *
     * This function is responsible for building and returning an instance of [AppDatabase].
     * The database is named "anime_db".
     *
     * @param context The application context, injected by Hilt.
     * @return A singleton instance of [AppDatabase].
     */
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "anime_db"
        ).build()
    }

    /**
     * Provides the [AnimeDao] instance from the [AppDatabase].
     *
     * @param db The [AppDatabase] instance.
     * @return The [AnimeDao] instance.
     */
    @Provides
    fun provideAnimeDao(db: AppDatabase): AnimeDao = db.animeDao()

    /**
     * Provides a singleton instance of [AnimeRepository].
     *
     * This function is responsible for creating and providing the repository
     * that handles data operations for anime, utilizing both remote API services
     * and local database access.
     *
     * @param api The [AnimeApiService] instance for network requests.
     * @param dao The [AnimeDao] instance for local database operations.
     * @return A singleton instance of [AnimeRepository].
     */
    @Provides
    @Singleton
    fun provideRepository(api: AnimeApiService, dao: AnimeDao): AnimeRepository {
        return AnimeRepositoryImpl(api, dao)
    }
}
