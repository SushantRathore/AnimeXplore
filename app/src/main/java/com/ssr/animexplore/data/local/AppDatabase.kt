package com.ssr.animexplore.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Room database for the application.
 *
 * This class defines the database configuration and serves as the main access point
 * to the persisted data. It includes a list of entities that represent the tables
 * in the database and provides abstract methods for accessing Data Access Objects (DAOs).
 *
 * @property animeDao Provides access to the [AnimeDao] for interacting with anime data.
 */
@Database(
    entities = [AnimeEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun animeDao(): AnimeDao
}
