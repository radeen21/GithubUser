package com.example.githubsearch.presentation.userdetail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
//    private val repo: GithubRepository
): ViewModel() {

//    private val _user = MutableStateFlow<GithubUser?>(null)
//    val user: StateFlow<GithubUser?> = _user

    fun getUserDetail(login: String) {
        viewModelScope.launch {
            try {
//                _user.value = repo.getUserDetail(login)
            } catch (e: Exception) {
                Log.e("UserDetailVM", e.message.toString())
            }
        }
    }
}
