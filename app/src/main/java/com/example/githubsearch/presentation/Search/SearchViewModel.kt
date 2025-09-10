package com.example.githubsearch.presentation.Search


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubsearch.domain.model.GithubUser
import com.example.githubsearch.domain.usecase.SearchUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUsersUseCase: SearchUsersUseCase
): ViewModel() {

    private val _users = MutableStateFlow<List<GithubUser>>(emptyList())
    val users: StateFlow<List<GithubUser>> = _users

    fun searchUser(query: String) {
        viewModelScope.launch {
            _users.value = searchUsersUseCase(query)
        }
    }
}
