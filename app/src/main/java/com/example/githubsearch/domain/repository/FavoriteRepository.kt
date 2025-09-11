package com.example.githubsearch.domain.repository

import com.example.githubsearch.domain.model.User
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {
    fun getAllFavorites(): Flow<List<User>>
    suspend fun addFavorite(user: User)
    suspend fun removeFavorite(user: User)
    suspend fun getFavoriteById(id: Int): User?
}