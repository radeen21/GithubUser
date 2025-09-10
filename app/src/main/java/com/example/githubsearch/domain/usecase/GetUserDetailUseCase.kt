package com.example.githubsearch.domain.usecase

import com.example.githubsearch.data.repository.GithubRepository
import com.example.githubsearch.domain.model.GithubUserDetail
import javax.inject.Inject

class GetUserDetailUseCase @Inject constructor(
    private val repository: GithubRepository
) {
    suspend operator fun invoke(username: String): GithubUserDetail {
        return repository.getUserDetail(username)
    }
}