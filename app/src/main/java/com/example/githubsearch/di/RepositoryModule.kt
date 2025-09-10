package com.example.githubsearch.di

import com.example.githubsearch.data.repository.GithubRepository
import com.example.githubsearch.data.repository.GithubRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindGithubRepository(
        impl: GithubRepositoryImpl
    ): GithubRepository
}
