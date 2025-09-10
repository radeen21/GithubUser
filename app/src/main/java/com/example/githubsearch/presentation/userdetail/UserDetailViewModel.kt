package com.example.githubsearch.presentation.userdetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubsearch.domain.model.GithubUserDetail
import com.example.githubsearch.domain.usecase.GetUserDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val getUserDetailUseCase: GetUserDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _userDetail = MutableStateFlow<GithubUserDetail?>(null)
    val userDetail: StateFlow<GithubUserDetail?> = _userDetail

    init {
        savedStateHandle.get<String>("itemId")?.let { username ->
            viewModelScope.launch {
                val detail = getUserDetailUseCase(username)
                _userDetail.value = detail
            }
        }
    }

}

