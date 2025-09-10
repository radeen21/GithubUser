package com.example.githubsearch.data.remote

import com.example.githubsearch.domain.model.GithubSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApiService {
    @GET("search/users")
    suspend fun searchUsers(
        @Query("q") query: String
    ): GithubSearchResponse
}