package com.example.githubsearch.presentation.userdetail

import androidx.lifecycle.SavedStateHandle
import com.example.githubsearch.domain.model.GithubUserDetail
import com.example.githubsearch.domain.usecase.GetUserDetailUseCase
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
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class UserDetailViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    private lateinit var getUserDetailUseCase: GetUserDetailUseCase
    private lateinit var savedStateHandle: SavedStateHandle
    private lateinit var viewModel: UserDetailViewModel


    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        getUserDetailUseCase = mockk()
        savedStateHandle = SavedStateHandle(mapOf("itemId" to "john1"))
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `userDetail is loaded correctly`() = runTest {
        val mockDetail = GithubUserDetail(
            login = "john1",
            avatarUrl = "url1",
            name = "John Doe",
            followers = 10,
            following = 5,
            publicRepos = 3,
            bio = "test"
        )

        coEvery { getUserDetailUseCase("john1") } returns mockDetail
        viewModel = UserDetailViewModel(getUserDetailUseCase, savedStateHandle)
        testDispatcher.scheduler.advanceUntilIdle()
        assertEquals(mockDetail, viewModel.userDetail.value)
    }
}