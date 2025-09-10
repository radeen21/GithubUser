package com.example.githubsearch.presentation.userdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter

@Composable
fun UserDetailScreen(
    navController: NavHostController,
    username: String,
    viewModel: UserDetailViewModel = hiltViewModel()
) {
    val userDetail by viewModel.userDetail.collectAsState()

    userDetail?.let { user ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Image(
                painter = rememberImagePainter(user.avatarUrl),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = user.name ?: "No name", style = MaterialTheme.typography.h6)
            Text(text = "Username: ${user.login}")
            Text(text = "Bio: ${user.bio ?: "No bio"}")
            Text(text = "Public repos: ${user.publicRepos}")
            Text(text = "Followers: ${user.followers}")
            Text(text = "Following: ${user.following}")
        }
    } ?: run {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }
}
