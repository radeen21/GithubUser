package com.example.githubsearch.data.repository

import com.example.githubsearch.data.remote.GithubApiService
import com.example.githubsearch.domain.model.GithubUser
import com.example.githubsearch.domain.model.GithubUserDetail
import javax.inject.Inject

interface GithubRepository {
    suspend fun searchUsers(query: String): List<GithubUser>
    suspend fun getUserDetail(username: String): GithubUserDetail
}

class GithubRepositoryImpl @Inject constructor(
    private val apiService: GithubApiService
) : GithubRepository {

    override suspend fun searchUsers(query: String): List<GithubUser> {
        return apiService.searchUsers(query).items
    }

    override suspend fun getUserDetail(username: String): GithubUserDetail {
        return apiService.getUserDetail(username)
    }
}