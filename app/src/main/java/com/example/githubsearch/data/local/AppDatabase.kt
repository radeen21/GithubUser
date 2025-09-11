package com.example.githubsearch.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.githubsearch.data.local.dao.FavoriteUserDao
import com.example.githubsearch.data.local.entity.FavoriteUserEntity

@Database(entities = [FavoriteUserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteUserDao(): FavoriteUserDao
}