package com.example.githubsearch.presentation.userdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun UserDetailScreen(login: String?, viewModel: UserDetailViewModel = hiltViewModel()) {
//    val user by viewModel.user.value
//    viewModel.user.collectAsState()
    LaunchedEffect(login) { login?.let { viewModel.getUserDetail(it) } }

//    user?.let {
//        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
//            Image(
//                painter = rememberAsyncImagePainter(it.avatarUrl),
//                contentDescription = null,
//                modifier = Modifier.size(128.dp).clip(CircleShape)
//            )
//            Spacer(modifier = Modifier.height(16.dp))
//            Text(it.login, fontSize = 24.sp, fontWeight = FontWeight.Bold)
//            it.bio?.let { bio -> Text(bio) }
//        }
//    }
}
