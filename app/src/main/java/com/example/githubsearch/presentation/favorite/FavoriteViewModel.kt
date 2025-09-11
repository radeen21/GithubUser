package com.example.githubsearch.presentation.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubsearch.domain.model.User
import com.example.githubsearch.domain.usecase.AddFavoriteUserUseCase
import com.example.githubsearch.domain.usecase.GetFavoriteUsersUseCase
import com.example.githubsearch.domain.usecase.RemoveFavoriteUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getFavorites: GetFavoriteUsersUseCase,
    private val addFavorite: AddFavoriteUserUseCase,
    private val removeFavorite: RemoveFavoriteUserUseCase
) : ViewModel() {

    val favorites = getFavorites()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun addUser(user: User) {
        viewModelScope.launch { addFavorite(user) }
    }

    fun removeUser(user: User) {
        viewModelScope.launch { removeFavorite(user) }
    }
}