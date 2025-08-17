package com.ssr.animexplore.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object (DAO) for accessing and managing anime data in the local database.
 * This interface provides methods for querying and inserting anime entities.
 */
@Dao
interface AnimeDao {

    @Query("SELECT * FROM anime_table")
    fun getAllAnimeFlow(): Flow<List<AnimeEntity>>

    @Query("SELECT * FROM anime_table")
    suspend fun getAllAnimeOnce(): List<AnimeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(animeList: List<AnimeEntity>)
}

