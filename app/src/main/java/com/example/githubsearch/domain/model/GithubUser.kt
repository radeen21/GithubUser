package com.example.githubsearch.domain.model

import com.squareup.moshi.Json

data class GithubUser(
    val login: String,
//    val avatarUrl: String?
    @Json(name = "avatar_url") val avatarUrl: String?
)
