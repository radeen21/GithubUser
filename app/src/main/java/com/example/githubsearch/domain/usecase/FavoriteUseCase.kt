package com.example.githubsearch.domain.usecase

import com.example.githubsearch.domain.model.User
import com.example.githubsearch.domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.Flow

class GetFavoriteUsersUseCase(private val repository: FavoriteRepository) {
    operator fun invoke(): Flow<List<User>> = repository.getAllFavorites()
}

class AddFavoriteUserUseCase(private val repository: FavoriteRepository) {
    suspend operator fun invoke(user: User) = repository.addFavorite(user)
}

class RemoveFavoriteUserUseCase(private val repository: FavoriteRepository) {
    suspend operator fun invoke(user: User) = repository.removeFavorite(user)
}

class GetFavoriteByIdUseCase(private val repository: FavoriteRepository) {
    suspend operator fun invoke(id: Int): User? = repository.getFavoriteById(id)
}