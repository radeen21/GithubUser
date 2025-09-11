package com.example.githubsearch.data.repository

import com.example.githubsearch.data.local.dao.FavoriteUserDao
import com.example.githubsearch.data.local.entity.FavoriteUserEntity
import com.example.githubsearch.domain.model.User
import com.example.githubsearch.domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FavoriteRepositoryImpl(
    private val dao: FavoriteUserDao
) : FavoriteRepository {

    override fun getAllFavorites(): Flow<List<User>> =
        dao.getAllFavorites().map { list ->
            list.map { entity -> entity.toDomain() }
        }

    override suspend fun addFavorite(user: User) {
        dao.insertFavorite(user.toEntity())
    }

    override suspend fun removeFavorite(user: User) {
        dao.deleteFavorite(user.toEntity())
    }

    override suspend fun getFavoriteById(id: Int): User? {
        return dao.getFavoriteById(id)?.toDomain()
    }

    private fun FavoriteUserEntity.toDomain() = User(id, login, avatarUrl)
    private fun User.toEntity() = FavoriteUserEntity(id, login, avatarUrl)
}