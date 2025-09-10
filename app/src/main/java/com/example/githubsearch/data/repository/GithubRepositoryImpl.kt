package com.example.githubsearch.data.repository

import com.example.githubsearch.data.remote.GithubApiService
import com.example.githubsearch.domain.GithubUser
import javax.inject.Inject

interface GithubRepository {
    suspend fun searchUsers(query: String): List<GithubUser>
}

class GithubRepositoryImpl @Inject constructor(
    private val apiService: GithubApiService
) : GithubRepository {
    override suspend fun searchUsers(query: String): List<GithubUser> {
        return apiService.searchUsers(query).items
    }
}