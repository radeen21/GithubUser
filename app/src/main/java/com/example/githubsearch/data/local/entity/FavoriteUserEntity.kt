package com.example.githubsearch.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_users")
data class FavoriteUserEntity(
    @PrimaryKey val id: Int,
    val login: String,
    val avatarUrl: String
)