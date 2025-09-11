package com.example.githubsearch.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.githubsearch.data.local.entity.FavoriteUserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteUserDao {

    @Query("SELECT * FROM favorite_users")
    fun getAllFavorites(): Flow<List<FavoriteUserEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(user: FavoriteUserEntity)

    @Delete
    suspend fun deleteFavorite(user: FavoriteUserEntity)

    @Query("SELECT * FROM favorite_users WHERE id = :id LIMIT 1")
    suspend fun getFavoriteById(id: Int): FavoriteUserEntity?
}