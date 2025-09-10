package com.example.githubsearch.domain.model

import com.squareup.moshi.Json

data class GithubUserDetail(
    @Json(name = "login") val login: String,
    @Json(name = "avatar_url") val avatarUrl: String,
    @Json(name = "name") val name: String?,
    @Json(name = "bio") val bio: String?,
    @Json(name = "public_repos") val publicRepos: Int,
    @Json(name = "followers") val followers: Int,
    @Json(name = "following") val following: Int
)

