package com.example.githubsearch.presentation.Search


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(
//    private val repo: GithubRepository
): ViewModel() {

//    private val _users = MutableStateFlow<List<GithubUser>>(emptyList())
//    val users: StateFlow<List<GithubUser>> = _users
//
//    fun searchUser(query: String) {
//        viewModelScope.launch {
//            try {
//                val result = repo.searchUsers(query)
//                _users.value = result.items
//            } catch(e: Exception) {
//                Log.e("SearchViewModel", e.message.toString())
//            }
//        }
//    }
}
