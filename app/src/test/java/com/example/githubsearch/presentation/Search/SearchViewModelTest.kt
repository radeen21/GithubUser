package com.example.githubsearch.presentation.Search

import com.example.githubsearch.domain.model.GithubUser
import com.example.githubsearch.domain.usecase.SearchUsersUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class SearchViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    private lateinit var searchUsersUseCase: SearchUsersUseCase
    private lateinit var viewModel: SearchViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        searchUsersUseCase = mockk()
        viewModel = SearchViewModel(searchUsersUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `searchUser returns list of users`() = runTest {
        val query = "john"
        val mockUsers = listOf(GithubUser("john1", "url1"), GithubUser("john2", "url2"))

        coEvery { searchUsersUseCase(query) } returns mockUsers

        viewModel.searchUser(query)
        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals(mockUsers, viewModel.users.value)
    }
}