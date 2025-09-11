package com.example.githubsearch.di

import android.content.Context
import androidx.room.Room
import com.example.githubsearch.data.local.AppDatabase
import com.example.githubsearch.data.local.dao.FavoriteUserDao
import com.example.githubsearch.data.repository.FavoriteRepositoryImpl
import com.example.githubsearch.domain.repository.FavoriteRepository
import com.example.githubsearch.domain.usecase.AddFavoriteUserUseCase
import com.example.githubsearch.domain.usecase.GetFavoriteByIdUseCase
import com.example.githubsearch.domain.usecase.GetFavoriteUsersUseCase
import com.example.githubsearch.domain.usecase.RemoveFavoriteUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "app_database")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideFavoriteDao(db: AppDatabase): FavoriteUserDao = db.favoriteUserDao()

    @Provides
    @Singleton
    fun provideFavoriteRepository(dao: FavoriteUserDao): FavoriteRepository =
        FavoriteRepositoryImpl(dao)

    @Provides
    fun provideGetFavoritesUseCase(repo: FavoriteRepository) = GetFavoriteUsersUseCase(repo)

    @Provides
    fun provideAddFavoriteUseCase(repo: FavoriteRepository) = AddFavoriteUserUseCase(repo)

    @Provides
    fun provideRemoveFavoriteUseCase(repo: FavoriteRepository) = RemoveFavoriteUserUseCase(repo)

    @Provides
    fun provideGetFavoriteByIdUseCase(repo: FavoriteRepository) = GetFavoriteByIdUseCase(repo)
}