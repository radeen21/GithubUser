package com.example.githubsearch.domain.model

import com.squareup.moshi.Json

data class GithubUser(
    val login: String,
    @Json(name = "avatar_url") val avatarUrl: String?,
    val id: Int
)

fun GithubUser.toDomainUser() = User(
    login = login,
    avatarUrl = avatarUrl?:"",
    id = id
)
