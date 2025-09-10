package com.example.githubsearch.domain.usecase

import com.example.githubsearch.data.repository.GithubRepository
import com.example.githubsearch.domain.model.GithubUser
import javax.inject.Inject

class SearchUsersUseCase @Inject constructor(
    private val repository: GithubRepository
) {
    suspend operator fun invoke(query: String): List<GithubUser> {
        return repository.searchUsers(query)
    }
}
